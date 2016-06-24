package ConcurrentProgramming

/**
  * Created by Goduguluri on 6/22/2016.
  */
object Ex1 extends App{

  // we may use only one core of the process to compute this application.

  def sumOfFactors(number: Int) = {
    (0 /: (1 to number)) { (sum, i) => if (number % i == 0) sum + i else sum }
  }
  def isPerfect(candidate: Int) = 2 * candidate == sumOfFactors(candidate)
  println("6 is perfect? " + isPerfect(6))
  println("33550336 is perfect? " + isPerfect(33550336))
  println("33550337 is perfect? " + isPerfect(33550337))



}
