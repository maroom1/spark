import java.util

/**
  * Created by Goduguluri on 6/20/2016.
  */
object Temp extends App{
  def findMax(temperatures : List[Int]) = {
    temperatures.foldLeft(Integer.MIN_VALUE) { Math.max }
  }
 println(findMax(List(5,8,40,90,34,12,0,65,99,102,65)))

  class Marker private (val color: String) {
    override def toString() : String = "marker color " + color
  }
  object Marker {
    private val markers = Map(
      "red" -> new Marker("red"),
      "blue" -> new Marker("blue"),
      "green" -> new Marker("green")
    )
    def primaryColors = "red, green, blue"
    def apply(color: String) = if (markers.contains(color)) markers(color) else null
  }
  println("Primary colors are : " + Marker.primaryColors)
  println(Marker("blue"))
  println(Marker("red"))

  import  java.util._

  val list=new util.ArrayList[Any]
  list.add(1)
  list.add("2")
  import java.util._
  var list1 = new ArrayList[Int]
  var list2 = new ArrayList[Any]
  var ref1 : Int = 1
  var ref2 : Any = null
  ref2 = ref1 //OK
 // list2 = list1 // Compilation Error
  def madMethod() = { throw new IllegalArgumentException() } // return type Nothing
  println(getClass().getDeclaredMethod("madMethod").
   getReturnType().getName())

  def commentOnPractice(input: String) = {
    //rather than returning null
    if (input == "test") Some("good") else None
  }
/*
  You’re less likely to get NullPointerException
    because of unchecked null references. By calling the getOrElse( )
  method on the returned Option[T], you can proactively indicate what to
  do in case the result is nonexistent (None).
*/

  for (input <- Predef.Set("test", "hack")) {
    val comment = commentOnPractice(input)
    println("input " + input + " comment " +
      comment.getOrElse("Found no comments"))
  }
/*
  If you define your method with an equals
    sign (=), then Scala infers the return type*/

  def printMethodInfo(methodName: String) {
    println("The return type of " + methodName + " is " +
      getClass().getDeclaredMethod(methodName).getReturnType().getName())
  }
  def method1() { 6 }
  def method2() = { 6 }
  def method3() = 6
  def method4 : Double = 6
  def method5() = {}
  printMethodInfo("method1") //void
  printMethodInfo("method2") //int
  printMethodInfo("method3") //int
  printMethodInfo("method4") //double

  printMethodInfo("method5")  //void

  def divide(op1: Double, op2: Double) = op1/op2

  def max(values: Int*) = values.foldLeft(values(0)) { Math.max }
  println(max(2, 5, 3, 7, 1, 6))

  val numbers = Array(2, 5, 3, 7, 1, 6)
//  println(max(numbers)) // type mismatch error
  /*, we can
    explode the array into discrete values—use the series of symbols : _* for
  this purpose:*/
  println(max(numbers: _*)) //explode the elements of array with _*

//  println(numbers)
  numbers.foreach(println)
/*
  The ability to send a collection of subclass instances to a collection of
  base class is called covariance. And the ability to send a collection of
    superclass instances to a collection of subclass is called contravariance.
  By default Scala does not allow either one of them.*/







}
