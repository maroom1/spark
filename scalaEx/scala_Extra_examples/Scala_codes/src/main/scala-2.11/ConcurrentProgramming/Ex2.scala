package ConcurrentProgramming

/**
  * Created by Goduguluri on 6/22/2016.
  */
object Ex2 extends App{

  //  Since we have 4 core process , we use all the 4 coress to process the previous application which will give give
  //high throughput

  // we can do this with Concurrent programming from Scala Actors which is event-based lightweight thread
  //where we send objects as messages between the threads which is free from deadloacks , data contention , performance


  import scala.actors.Actor._

  def sumOfFactorsInRange(lower: Int, upper: Int, number: Int) = {
    println(14)
    (0 /: (lower to upper)) { (sum, i) => if (number % i == 0) sum + i else sum }
  }

  def isPerfectConcurrent(candidate: Int) = {
    println(1)
    val RANGE = 1000000
    
    println(2)
    val numberOfPartitions = (candidate.toDouble / RANGE).ceil.toInt
    println(3)
    val caller = self
    println(4)
    for (i <- 0 until numberOfPartitions) {
      println(5)
      val lower = i * RANGE + 1;
      println(6)
      val upper = candidate min (i + 1) * RANGE
      println(7)
      actor { //<label id="code.fasterperfectnumberfinder.actor" />
        println(8)
        caller ! sumOfFactorsInRange(lower, upper, candidate) //<label id="code.fasterperfectnumberfinder.send"/>
        println(9)
      }
      println(10)
    }
    println(11)
    val sum = (0 /: (0 until numberOfPartitions)) { (partialSum, i) =>
      println(12)
      receive { //<label id="code.fasterperfectnumberfinder.receive" />

        case sumInRange : Int => partialSum + sumInRange

      }

    }
    println(13)
    2 * candidate == sum
  }

  println("6 is perfect? " + isPerfectConcurrent(6))
  //println("33550336 is perfect? " + isPerfectConcurrent(33550336))
  //println("33550337 is perfect? " + isPerfectConcurrent(33550337))

/* compilation time differences
  1:52:29 PM Compilation completed successfully in 2s 749ms wihtout actors
    1:52:38 PM Compilation completed successfully in 620ms with actors*/

}
