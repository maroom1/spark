class AuxDuck{
	var size = 0;
	var age = 0;
	println("Sathya")
	def this(size: Int){
		  this()// Calls the primary constructor
		  this.size = size
      println(this.getClass.getName)
    }

	def this(size:Int, age:Int)
	{
		this(size) // calls previous auxiliary constructor
		this.age= age
	}
}

object DemoDuck extends App {
  var d1 = new AuxDuck
  println("1 executed")
  var d2 = new AuxDuck(5)
  
  println("2 executed")
  var d3 = new AuxDuck(5,10)
  
  println("3 executed")
  println (d1.size + "," + d1.age)
  println (d2.size, d2.age)
  println (d3.size, d3.age)
  
  println("all callss executed")
}