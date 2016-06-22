/**
  * Created by Goduguluri on 6/21/2016.
  */
object PartialFunc extends App{

  import java.util.Date
  def log(date: Date, message: String) {
    //...
    println(date + "----" + message)
  }
  val date = new Date
  log(date, "message1")
  log(date, "message2")
  log(date, "message3")

  val logWithDateBound = log(new Date, _ : String) // assigning the fucntion
  println(getClass.getDeclaredMethod("logWithDateBound").getReturnType.getName)
  logWithDateBound("message1")
  logWithDateBound("message2")
  logWithDateBound("message3")

/*
  A closure is a function, whose return value depends on the value of one or more variables declared outside this function.*/


  def loopThrough(number: Int)(closure: Int => Unit) {
    for (i <- 1 to number) { closure(i) }
  }

  var result = 0
  val addIt = { value:Int => result += value }

  loopThrough(10) { addIt }
  println("Total of values from 1 to 10 is " + result)
  result = 0
  loopThrough(5) { addIt }
  println("Total of values from 1 to 5 is " + result)

  var product = 1
  loopThrough(5) { product *= _ }
  println("Product of values from 1 to 5 is " + product)



}
