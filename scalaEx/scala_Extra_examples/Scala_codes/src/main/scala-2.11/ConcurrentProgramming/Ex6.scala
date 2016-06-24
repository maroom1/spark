package ConcurrentProgramming

/**
  * Created by Goduguluri on 6/23/2016.
  */
object Ex6 extends App{

  import scala.actors._
  import Actor._
  class AnsweringService(val folks: String*) extends Actor {
    def act() {
      while(true) {
        receive {
          case (caller : Actor, name : String, msg : String) =>
            caller ! (
              if(folks.contains(name))
                String.format("Hey it's %s got message %s", name, msg)
              else
                String.format("Hey there's no one with the name %s here", name)
              )
          case "ping" => println("ping!")
          case "quit" => println("exiting actor")
            exit // we are ezisting the actor
          case "restart" => println("restarting actor")
            restart // we are ezisting the actor
        }
      }
    }
  }
  println(mailboxSize)

  val answeringService1 = new AnsweringService("Sara", "Kara", "John")

  answeringService1 ! (self, "Sara", "In town")

  answeringService1 ! (self, "Kara", "Go shopping?")
  answeringService1.start()
  answeringService1 ! (self, "John", "Bug fixed?")
  answeringService1 ! (self, "Bill", "What's up")

  for(i <- 1 to 4) { receive { case msg => println(msg) } }

  answeringService1 ! "ping"
  println(answeringService1.getState)

  answeringService1 ! "quit"
  println(mailboxSize)

  answeringService1 ! "ping"
  Thread.sleep(2000)
  println("The last ping was not processed")
  println(mailboxSize)
  println("Status of actor after Quit : "+answeringService1.getState)
 answeringService1.restart()
  println("mailbox after restart "+mailboxSize)
  println("Status of actor after restart : "+answeringService1.getState)
  println("quitting------")
  answeringService1 ! "quit"
  println("Status of actor now : "+answeringService1.getState)




  //answeringService1 ! "restart" -- not working



}
