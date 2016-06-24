package ConcurrentProgramming

/**
  * Created by Goduguluri on 6/23/2016.
  */
object Ex7 extends App{

  import scala.actors._
  import Actor._
  def isPrime(number: Int) = {
    println("Going to find if " + number + " is prime")
    var result = true
    if (number == 2 || number == 3) result = true
    for (i <- 2 to Math.sqrt(number.toDouble).floor.toInt; if result) {
      if (number % i == 0) result = false
    }
    println("done finding if " + number + " is prime")
    result
  }
  val primeTeller = actor {
    var continue = true

     while (continue) { // this is always true until sent quit message to actor
     receive {
    //case (caller : Actor, number: Int) => caller ! (number, isPrime(number)) // println((number, isPrime(number)))
    case (caller : Actor, number: Int) => actor { caller ! (number, isPrime(number)) }
/*
      If we run the code again with the previous change, you’ll notice that
       multiple calls to isPrime( ) are executed concurrently, as shown here:
*/

    case "quit" => continue = false
     }
     }
     }

  primeTeller ! (self, 2)
  primeTeller ! (self, 131)
  primeTeller ! (self, 132)

  for (i <- 1 to 3) {
    receive {
      case (number, result) => println(number + " is prime? " + result)
    }
  }
  primeTeller ! "quit"

/*
    . Actors will process messages
    as they are received and respond as soon as they’re ready. There
  is no pre-imposed order on which messages are received and processed
  by an actor.
*/


}
