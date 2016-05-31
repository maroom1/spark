import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object Joins {
  def main(args: Array[String]) {

	val sc = new SparkContext(new SparkConf().setAppName("Spark Joins").setMaster("local[2]"))

	case class Customer (cust_id: Int, name: String)
	case class Txn (cust_id: Int, store_id: String, amount: Float)


	val custs = sc.textFile("/home/edureka/Downloads/Server_log_Sample/custs").map(_.split("\t"))
	val cust_recs = custs.map( r => (r(0).toInt, Customer(r(0).toInt, r(1))))
  cust_recs.foreach(println)

	val txns = sc.textFile("/home/edureka/Downloads/Server_log_Sample/custs_txns").map(_.split("\t"))
	val txns_recs = txns.map( r => (r(0).toInt, Txn(r(0).toInt, r(1), r(2).toFloat)))
	txns_recs.foreach(println)
	println(txns_recs.toDebugString)
 
	
	/*
	 * The lines below are showing various types of joins
	 * which are as easy as using a keyword!
	 */
	val joind = cust_recs.join(txns_recs)
	
	val leftOuterjoind = cust_recs.leftOuterJoin(txns_recs)
	val cartesianJoined = cust_recs.cartesian(txns_recs)
	val cogrpd = cust_recs.cogroup(txns_recs)
    val rightOuterjoind = cust_recs.rightOuterJoin(txns_recs)
   val subtractbykey=cust_recs.subtractByKey(txns_recs)
subtractbykey.foreach(println)
//	 joind.foreach(println)
 // leftOuterjoind.foreach(println)
 // cartesianJoined.foreach(println)
	// cogrpd.foreach(println)
	}
}

//output

/*
 * Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties
cust_recs.foreach(println)
(3,Customer(3,Vinay))
(1,Customer(1,Vishal))
(2,Customer(2,Vijay))
txns_recs.foreach(println)
(2,Txn(2,001,7642.62))
(4,Txn(4,001,2345.93))
(1,Txn(1,001,1563.47))
(1,Txn(1,001,1589.93))
(1,Txn(1,002,2345.98))
(2,Txn(2,001,8765.73))
println(txns_recs.toDebugString)
(2) MapPartitionsRDD[7] at map at Joins.scala:19 []
 |  MapPartitionsRDD[6] at map at Joins.scala:18 []
 |  MapPartitionsRDD[5] at textFile at Joins.scala:18 []
 |  /home/edureka/Downloads/Server_log_Sample/custs_txns HadoopRDD[4] at textFile at Joins.scala:18 []


joind.foreach(println)
(2,(Customer(2,Vijay),Txn(2,001,8765.73)))
(2,(Customer(2,Vijay),Txn(2,001,7642.62)))
(1,(Customer(1,Vishal),Txn(1,001,1563.47)))
(1,(Customer(1,Vishal),Txn(1,001,1589.93)))
(1,(Customer(1,Vishal),Txn(1,002,2345.98)))


leftOuterjoind.foreach(println)
(2,(Customer(2,Vijay),Some(Txn(2,001,8765.73))))
(1,(Customer(1,Vishal),Some(Txn(1,001,1563.47))))
(1,(Customer(1,Vishal),Some(Txn(1,001,1589.93))))
(1,(Customer(1,Vishal),Some(Txn(1,002,2345.98))))
(2,(Customer(2,Vijay),Some(Txn(2,001,7642.62))))
(3,(Customer(3,Vinay),None))

cartesianJoined.foreach(println)
((1,Customer(1,Vishal)),(1,Txn(1,001,1563.47)))
((1,Customer(1,Vishal)),(1,Txn(1,001,1589.93)))
((1,Customer(1,Vishal)),(1,Txn(1,002,2345.98)))
((1,Customer(1,Vishal)),(2,Txn(2,001,8765.73)))
((1,Customer(1,Vishal)),(2,Txn(2,001,7642.62)))
((1,Customer(1,Vishal)),(4,Txn(4,001,2345.93)))
((2,Customer(2,Vijay)),(1,Txn(1,001,1563.47)))
((2,Customer(2,Vijay)),(1,Txn(1,001,1589.93)))
((2,Customer(2,Vijay)),(1,Txn(1,002,2345.98)))
((2,Customer(2,Vijay)),(2,Txn(2,001,8765.73)))
((2,Customer(2,Vijay)),(2,Txn(2,001,7642.62)))
((2,Customer(2,Vijay)),(4,Txn(4,001,2345.93)))
((3,Customer(3,Vinay)),(1,Txn(1,001,1563.47)))
((3,Customer(3,Vinay)),(1,Txn(1,001,1589.93)))
((3,Customer(3,Vinay)),(1,Txn(1,002,2345.98)))
((3,Customer(3,Vinay)),(2,Txn(2,001,8765.73)))
((3,Customer(3,Vinay)),(2,Txn(2,001,7642.62)))
((3,Customer(3,Vinay)),(4,Txn(4,001,2345.93)))

cogrpd.foreach(println)
(4,(CompactBuffer(),CompactBuffer(Txn(4,001,2345.93))))
(2,(CompactBuffer(Customer(2,Vijay)),CompactBuffer(Txn(2,001,8765.73), Txn(2,001,7642.62))))
(1,(CompactBuffer(Customer(1,Vishal)),CompactBuffer(Txn(1,001,1563.47), Txn(1,001,1589.93), Txn(1,002,2345.98))))
(3,(CompactBuffer(Customer(3,Vinay)),CompactBuffer()))
 * 
 * 
 * 
 * */
