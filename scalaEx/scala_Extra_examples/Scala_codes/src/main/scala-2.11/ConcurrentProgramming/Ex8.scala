package ConcurrentProgramming

/**
  * Created by Goduguluri on 6/23/2016.
  */
object Ex8 extends App{

  import scala.actors.Actor._
  val caller = self
  val accumulator = actor {
    var sum = 0
    var continue = true
    while (continue) {
      sum += receive {
        case number : Int => number
        case "quit" =>
          continue = false
          0
      }
    }
    caller ! sum
  }
  accumulator ! 1
  accumulator ! 7
  accumulator ! 8
  accumulator ! "quit"
  receive { case result => println("Total is " + result) }
// enhanced programm Ex9
}
