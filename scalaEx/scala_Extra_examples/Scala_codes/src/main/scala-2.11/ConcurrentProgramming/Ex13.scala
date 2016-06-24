package ConcurrentProgramming

/**
  * Created by Goduguluri on 6/23/2016.
  */
object Ex13 extends App{
  //fix for Ex12

  import scala.actors._
  import Actor._
  val caller = self
  def accumulate(sum : Int) {
    reactWithin(500) {
      case number: Int => accumulate(sum + number)
      case TIMEOUT =>
        println("Timed out! Will send result now")
        caller ! sum
    }
    println("This will not be called...")
  }

  val accumulator = actor { accumulate(0) }
  accumulator ! 1
  accumulator ! 7
  accumulator ! 8
  receiveWithin(10000) { case result => println("Total is " + result) }
}
