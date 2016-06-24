package ConcurrentProgramming

/**
  * Created by Goduguluri on 6/23/2016.
  */
object Ex5 extends App{

  import scala.actors._
  import Actor._
  val fortuneTeller = actor {
    println("0")
    for (i <- 1 to 7) { // 7 depends on the total number of calls
      println("00")
      Thread.sleep(1000)

      receive {
        case _ => sender ! "your day will rock! " + i
        //case _ => reply("your day will rock! " + i) // same as above
      }
    }
  }
  println(1)
  println( fortuneTeller !? (2000, "what's ahead") )
  println(fortuneTeller !? ("king of the world"))
  println(2)
  println( fortuneTeller !? (1001, "what's ahead") ) // it will work since thread time is 1000
  println( fortuneTeller !? (500, "what's ahead") )
  println( fortuneTeller !? (200, "what's ahead") )
  println(3)
  val aPrinter = actor {
    receive { case msg => println("Ah, fortune message for you-" + msg) }
  }
  println(4)
  fortuneTeller.send("What's up", aPrinter)
  println(5)
  fortuneTeller ! "How's my future?"
 // Thread.sleep(3000)
println(5)
  receive { case msg : String => println("Received " + msg ) }
  println(6)
  println("Let's get that lost message")
  println(7)
  receive { case !(channel, msg) => println("Received belated message " + msg) } // syntac to receive message
  receive { case !(channel, msg) => println("Received belated message " + msg) }


}


/*The !?( ) method will return the result if the actor sends it a message
before the timeout. Otherwise, it has to return None, so this method’s
return type is Option[Any].
7
In the previous code we used sender to reference
the actor that sent us the last message. Alternately, we may use
the reply( ) method to implicitly send the message to the last sender. We
can alter the sender, if we desire. Suppose we want to send a message
to an actor, but we want it to forward the result to some other actor
(like aPrinter in the previous example). We can use the send( ) method. In
this case, the reply is sent to the delegate we assign instead of the real
caller. You may wonder what happened to the message that we did not
receive when we bailed out of the call to !?( ) because of a timeout. That
message was eventually received by your actor, and it sent a message
to itself to help process that message later. We can retrieve that message
using a special case class:8
![a](val ch : Channel[a], val msg : a). This
case class represents messages sent by an actor to itself. So, while we
continue to process other messages, if we are interested in processing
missed messages, we can use this case class to fetch it, as shown in
the last line of the previous code.*/