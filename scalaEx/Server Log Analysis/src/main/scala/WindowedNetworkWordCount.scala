
import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import StreamingContext._
import org.apache.hadoop.conf.Configuration
//import org.apache.hadoop.hbase.HBaseConfiguration
//import org.apache.hadoop.hbase.mapreduce.TableOutputFormat
import org.apache.hadoop.io.{IntWritable, Writable, Text}
//import org.apache.hadoop.hbase.client.{Put}
//import org.apache.hadoop.hbase.util.Bytes
//import org.apache.hadoop.hbase.client.{HBaseAdmin}
//import org.apache.hadoop.hbase.client.HTable

object WindowedNetworkWordCount {
  def main(args: Array[String]) {
    


    val sparkConf = new SparkConf().setAppName("WindowedNetworkWordCount").setMaster("local[2]")
    val ssc = new StreamingContext(sparkConf, Seconds(15))

    val lines = ssc.socketTextStream("localhost", 9999)
    val words = lines.flatMap(_.split(" "))
    /*
     * The code below is for the rolling window of previuos two batches
     */
     val wordCounts = words.map(x => (x, 1)).reduceByKeyAndWindow(_+_,Seconds(30))
    wordCounts.print()
    ssc.start()
    ssc.awaitTermination()
  }

}
