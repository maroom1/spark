class Duck{
var size = 1
}
class Duck1{
val size = 1
}

object DuckDemo extends App {
  var f = new Duck
f.size = 10 // It calls f.size_=(10)
//f.size_=(10) // It calls f.size_=(10)
println(f.size) // It calls f.size()
  
   var f1 = new Duck1
//f1.size = 10 // you will get error
//f.size_=(10) // It calls f.size_=(10)
println(f1.size) // It calls f.size()
}