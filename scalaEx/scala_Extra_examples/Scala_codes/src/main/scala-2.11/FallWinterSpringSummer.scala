/**
  * Created by Goduguluri on 6/18/2016.
  */
import SingletonObj.ChecksumAccumulator.calculate
object FallWinterSpringSummer extends App {

  for (season <- List("fall", "winter", "spring"))
    println(season +": "+ calculate(season))
}