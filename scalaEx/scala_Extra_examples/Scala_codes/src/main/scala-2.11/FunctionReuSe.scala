/**
  * Created by Goduguluri on 6/21/2016.
  */
object FunctionReuSe extends App{

  class Equipment(val routine : Int => Int) {
    def simulate(input: Int) = {
      print("Running simulation...")
      routine(input)
    }
  }

  val equipment1 = new Equipment({input => println("calc with " + input); input })
  val equipment2 = new Equipment({input => println("calc with " + input); input })
  equipment1.simulate(4)
  equipment2.simulate(6)

  val calculator = { input : Int => println("calc with " + input); input }
  val equipment3 = new Equipment(calculator)
  val equipment4 = new Equipment(calculator)
  equipment3.simulate(4)
  equipment4.simulate(6)


// in Natural way more understable way


  def calculator(input: Int) = { println("calc with " + input); input }
  val equipment5 = new Equipment(calculator)
  val equipment6 = new Equipment(calculator)
  equipment5.simulate(4)
  equipment6.simulate(6)

  val arr = Array(1, 2, 3, 4, 5)
  println("Sum of all values in array is " +
    (0 /: arr) { (sum, elem) => sum + elem }
  )

  println("Sum of all values in array is " +
    (0 /: arr) { _ + _ }
  )

  val negativeNumberExists = arr.exists { _ < 0 }
  println("Array has negative number? " + negativeNumberExists)

  def max2(a: Int, b: Int) : Int = if (a > b) a else b
  var max = (Integer.MIN_VALUE /: arr) { (large, elem) => max2(large, elem) }


  max = (Integer.MIN_VALUE /: arr) { max2(_, _) }

 /* The _ represents not only a single parameter; it can represent the entire
  parameter list as well. So, we can modify the call to max2( ) as follows:
    */

  max = (Integer.MIN_VALUE /: arr) { max2 _ }

  max = (Integer.MIN_VALUE /: arr) { max2 }


}
