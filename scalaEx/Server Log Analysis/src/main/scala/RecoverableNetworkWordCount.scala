
import java.io.File
import java.nio.charset.Charset

import com.google.common.io.Files
import org.apache.spark.{Accumulator, SparkConf, SparkContext}
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.{Seconds, StreamingContext, Time}

/**
 * Use this singleton to get or register a Broadcast variable.
 */
object WordBlacklist {

  @volatile private var instance: Broadcast[Seq[String]] = null

  def getInstance(sc: SparkContext): Broadcast[Seq[String]] = {
    if (instance == null) {
      synchronized {
        if (instance == null) {
          val wordBlacklist = Seq("a", "b", "c")
          instance = sc.broadcast(wordBlacklist)
        }
      }
    }
    instance
  }
}

/**
 * Use this singleton to get or register an Accumulator.
 */
object DroppedWordsCounter {

  @volatile private var instance: Accumulator[Long] = null

  def getInstance(sc: SparkContext): Accumulator[Long] = {
    if (instance == null) {
      synchronized {
        if (instance == null) {
          instance = sc.accumulator(0L, "WordsInBlacklistCounter")
        }
      }
    }
    instance
  }
}

object RecoverableNetworkWordCount {

  def createContext(ip: String, port: Int, outputPath: String, checkpointDirectory: String)
    : StreamingContext = {

    // If you do not see this printed, that means the StreamingContext has been loaded
    // from the new checkpoint
    println("Creating new context")
    val outputFile = new File(outputPath)
    if (outputFile.exists()) outputFile.delete()
    val sparkConf = new SparkConf().setAppName("RecoverableNetworkWordCount").setMaster("local[2]")
    // Create the context with a 15 second batch size
    val ssc = new StreamingContext(sparkConf, Seconds(15))
    ssc.checkpoint(checkpointDirectory)

    // Create a socket stream on target ip:port and count the
    // words in input stream of \n delimited text (eg. generated by 'nc')
    val lines = ssc.socketTextStream(ip, port)
    val words = lines.flatMap(_.split(" "))
    val wordCounts = words.map(x => (x, 1)).reduceByKey(_ + _)
    wordCounts.foreachRDD((rdd: RDD[(String, Int)], time: Time) => {
      // Get or register the blacklist Broadcast
      val blacklist = WordBlacklist.getInstance(rdd.sparkContext)
      // Get or register the droppedWordsCounter Accumulator
      val droppedWordsCounter = DroppedWordsCounter.getInstance(rdd.sparkContext)
      // Use blacklist to drop words and use droppedWordsCounter to count them
      val counts = rdd.filter { case (word, count) =>
        if (blacklist.value.contains(word)) {
          droppedWordsCounter += count
          false
        } else {
          true
        }
      }.collect().mkString("[", ", ", "]")
      val output = "Counts at time " + time + " " + counts
      println(output)
      println("Dropped " + droppedWordsCounter.value + " word(s) totally")
      println("Appending to " + outputFile.getAbsolutePath)
      Files.append(output + "\n", outputFile, Charset.defaultCharset())
    })
    ssc
  }

  def main(args: Array[String]) {
    if (args.length != 4) {
      System.err.println("You arguments were " + args.mkString("[", ", ", "]"))
      System.err.println(
        """
          |Usage: RecoverableNetworkWordCount <hostname> <port> <checkpoint-directory>
          |     <output-file>. <hostname> and <port> describe the TCP server that Spark
          |     Streaming would connect to receive data. <checkpoint-directory> directory to
          |     HDFS-compatible file system which checkpoint data <output-file> file to which the
          |     word counts will be appended
          |
          |In local mode, <master> should be 'local[n]' with n > 1
          |Both <checkpoint-directory> and <output-file> must be absolute paths
        """.stripMargin
      )
      System.exit(1)
    }
    val Array(ip, IntParam(port), checkpointDirectory, outputPath) = args
    val ssc = StreamingContext.getOrCreate(checkpointDirectory,
      () => {
        createContext(ip, port, outputPath, checkpointDirectory)
      })
    ssc.start()
    ssc.awaitTermination()
  }
}

//nc -lk 9999 --- open in new terminal 
//then run the program 
// this program has arguments like 127.0.01 9999 '/home/edureka/Downloads/Server_log_Sample/networkoutput' '/home/edureka/Downloads/Server_log_Sample/chkptdir'