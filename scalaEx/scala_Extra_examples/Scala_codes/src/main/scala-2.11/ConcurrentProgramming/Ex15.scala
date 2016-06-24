package ConcurrentProgramming

import scala.actors.scheduler.SingleThreadedScheduler

/**
  * Created by Goduguluri on 6/23/2016.
  */
object Ex15 extends App{

  import scala.actors._
  import Actor._
  if (args.length > 0 && args(0) == "Single") {
    println("Command-line argument Single found")
    Scheduler.impl = new SingleThreadedScheduler
  }
  println("Main running in " + Thread.currentThread)
  actor { println("Actor1 running in " + Thread.currentThread) }
  actor { println("Actor2 running in " + Thread.currentThread) }
  receiveWithin(3000) { case _ => }

}
