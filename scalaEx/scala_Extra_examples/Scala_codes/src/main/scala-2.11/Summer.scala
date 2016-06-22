/**
  * Created by Goduguluri on 6/18/2016.
  */

import SingletonObj.ChecksumAccumulator.calculate
object Summer {
  def main(args: Array[String]) {
    for (arg <- args)
      println(arg +": "+ calculate(arg))
  }
}
