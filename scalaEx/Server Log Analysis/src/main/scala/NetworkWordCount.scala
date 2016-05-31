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

object NetworkWordCount {
  def main(args: Array[String]) {

    val sparkConf = new SparkConf().setAppName("NetworkWordCount").setMaster("local[2]")
    val ssc = new StreamingContext(sparkConf, Seconds(15))

    val lines = ssc.socketTextStream("localhost", 9999)
    val words = lines.flatMap(_.split(" ")).filter(x=> x match { //thos is extra filter to remove extra null words
      case "" => false
      case _  => true    
    } )
    val wordCounts = words.map(x => (x, 1)).reduceByKey(_ + _)
    wordCounts.print()
    ssc.start()
    ssc.awaitTermination()
  }

}
