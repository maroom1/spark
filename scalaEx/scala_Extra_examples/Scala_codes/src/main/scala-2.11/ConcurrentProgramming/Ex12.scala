package ConcurrentProgramming

/**
  * Created by Goduguluri on 6/23/2016.
  */
object Ex12 extends App{

  import scala.actors._
  import Actor._
  val caller = self
  def accumulate() {
    var sum = 0
    reactWithin(500) {
      case number: Int => sum += number
        accumulate()

      case TIMEOUT =>
        println("Timed out! Will send result now")
        caller ! sum
    }
    println("This will not be called...")
  }
  val accumulator = actor { accumulate() }
  accumulator ! 1
  accumulator ! 7
  accumulator ! 8
  receiveWithin(10000) { case result => println("Total is " + result) }

}
