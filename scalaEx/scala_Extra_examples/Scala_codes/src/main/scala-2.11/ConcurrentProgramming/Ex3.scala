package ConcurrentProgramming

/**
  * Created by Goduguluri on 6/23/2016.
  */
object Ex3 extends App{

  import Ex2._

  import Ex1._

  def countPerfectNumbersInRange(start : Int, end : Int,
                                 isPerfectFinder : Int => Boolean) = {
    val startTime = System.nanoTime()
    val numberOfPerfectNumbers = (0 /: (start to end)) { (count, candidate) =>
      if (isPerfectFinder(candidate)) count + 1 else count
    }
    val endTime = System.nanoTime()
    println("Found " + numberOfPerfectNumbers +
      " perfect numbers in given range, took " +
      (endTime - startTime)/1000000000.0 + " secs")
  }
  val startNumber = 33550300
  val endNumber = 33550400
   countPerfectNumbersInRange(startNumber, endNumber, isPerfect) // it took 66 seconds to complete
   countPerfectNumbersInRange(startNumber, endNumber, isPerfectConcurrent) // it took 30 seconmds to complete

}
