/**
  * Created by Goduguluri on 6/21/2016.
  */
object HigherOrderFuncAdV extends  App{

  /*the foldLeft( ) method. It is also the method /:.
  3
  Here is an example of using it to get the sum and max of elements in
    an array:*/
  val array = Array(2, 3, 5, 1, 6, 4)
  val sum = (0 /: array) { (sum, elem) => sum + elem }
  val max = (Integer.MIN_VALUE /: array) {
    (large, elem) => Math.max(large, elem) }
  println("Sum of elements in array " + array.mkString(" ") + " is " + sum)
  println("Max of elements in array " + array.mkString(" ") + " is " + max)

  val s1=array.foldLeft(0)((x,y)=>x+y)
  println(s1)
  val m1=array.foldLeft(0)(Math.max)
  println(m1)



}
