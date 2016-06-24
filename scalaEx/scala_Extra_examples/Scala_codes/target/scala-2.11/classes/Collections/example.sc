import scala.collection.mutable.Map

val m=Map("server1/db1" -> List("table1","table2"),"server2/db2" -> List("tabl3", "tabl4"),"server3/db3" -> List("tabl6", "tabl5"))

m.foreach(lst=>{lst._2.foreach(println(lst._1,_))})

m.foreach(lst=>{
  var key=lst._1
  var value=lst._2.toArray
  for(i <- 0 until value.length) {
    val x=key.split("/")
    for(j <- 0 until x.length )
      print(x(j)+" ")
    println(value(i))
  }

//  lst._2.foreach(println(lst._1,_))

})

