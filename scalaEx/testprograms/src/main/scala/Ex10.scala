class CompAccount{
val id = CompAccount.newNum()
println("class")
private var bal= 0.0
println(CompAccount.lastNum)
}

object CompAccount{
println("object")  
private var lastNum= 0;
private def newNum() = { lastNum+=1; lastNum}
}

object DemoComp extends App {
	val r1 = new CompAccount
  println()
	println("id1: " + r1.id) //id=1
	println("id2: " + r1.id)
}