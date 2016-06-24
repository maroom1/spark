package ConcurrentProgramming

/**
  * Created by Goduguluri on 6/23/2016.
  */
object Ex9 extends App{
/*
  This Ex8 code shows that even though receive( ) has special significance,
  it’s just another method. However, the code is blocked when we call
  receive( ) until a response is actually received. This is not good news if
  the actor from which we’re expecting a response is not going to send
  us one. This would leave us waiting forever—a liveness failure—and
  make us quite unpopular among colleagues. We can fix that by using
    the receiveWithin( ) method, which takes a timeout,*/

  import scala.actors._
  import scala.actors.Actor._
  val caller = self
  val accumulator = actor {
    var sum = 0
    var continue = true
    while (continue) {
      sum += receiveWithin(1000) {
        case number : Int => number
        case TIMEOUT =>
          println("Timed out! Will return result now")
          continue = false
          0
      }
    }
    caller ! sum
  }
  accumulator ! 1
  accumulator ! 7
  accumulator ! 8
  accumulator ! 10 ;
  receiveWithin(10000)
  //receive
  { case result:Int => println("Total is " + result)
  case TIMEOUT => println("received "+TIMEOUT)}

}
