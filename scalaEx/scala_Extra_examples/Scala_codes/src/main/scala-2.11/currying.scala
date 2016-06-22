/**
  * Created by Goduguluri on 6/21/2016.
  */
object currying extends App{
/*
  Instead of writing a
    method that takes one parameter list with multiple parameters, write it
  with multiple parameter lists with one parameter each (you may have
    more than one parameter in each list as well). That is, instead of def
  foo(a: Int, b: Int, c: Int) {}, write it as def foo(a: Int)(b: Int)(c: Int) {}. We can
    then call it as, for example, foo(1)(2)(3), foo(1){2}{3}, or even foo{1}{2}{3}*/

/*
  scala> def foo(a: Int)(b: Int)(c:Int) {}
  foo: (Int)(Int)(Int)Unit
    scala> foo _
  res1: (Int) => (Int) => (Int) => Unit = <function>
    scala>
*/


  def inject(arr: Array[Int], initial: Int)(operation: (Int, Int) => Int) : Int = {
    var carryOver = initial
    arr.foreach(element => carryOver = operation(carryOver, element))
    carryOver
  }

  val array = Array(2, 3, 5, 1, 6, 4)
  val sum = inject(array, 0) { (carryOver, elem) => carryOver + elem }
  println("Sum of elements in array " + array.toString() + " is " + sum)




}
