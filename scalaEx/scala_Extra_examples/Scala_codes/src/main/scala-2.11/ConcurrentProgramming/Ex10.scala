package ConcurrentProgramming

/**
  * Created by Goduguluri on 6/23/2016.
  */
object Ex10 extends App{

  import scala.actors._
  import Actor._
  val expectStringOrInteger = actor {
    for(i <- 1 to 4) {
      receiveWithin(1000) {
        case str : String => println("You said " + str)
        case num : Int => println("You gave " + num)
        case TIMEOUT => println("Timed out!")
        //case _ => println("received something...")
      }

    }

  }
  self ! "hello"
  expectStringOrInteger ! "only constant is change"
  expectStringOrInteger ! 1024
  expectStringOrInteger ! 22.22
  expectStringOrInteger ! (self, 1024)
  //expectStringOrInteger ! "testing"
  //expectStringOrInteger ! " test 2"
  receiveWithin(1000) {
    case s:String => println("received "+s)
    case _ => println("received something")
  }
}
