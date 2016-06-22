/**
  * Created by Goduguluri on 6/18/2016.
  */
object SingletonObj {

    /**
      * A class that calculates a checksum of bytes. This class
      * is not thread-safe.
      */
    class ChecksumAccumulator {

      private var sum = 0

      /**
        * Adds the passed <code>Byte</code> to the checksum
        * calculation.
        *
        * $@$param b the <code>Byte</code> to add
        */
      def add(b: Byte) { sum += b }

      /**
        * Gets a checksum for all the <code>Byte</code>s passed
        * to <code>add</code>. The sum of the integer
        * returned by this method, when added to the
        * sum of all the passed bytes will yield zero.
        */
      def checksum(): Int = ~(sum & 0xFF) + 1
    }

    // In file ChecksumAccumulator.scala
    import scala.collection.mutable.Map

    object ChecksumAccumulator {

      private val cache = Map[String, Int]()

      def calculate(s: String): Int =
        if (cache.contains(s))
          cache(s)
        else {

          val acc = new ChecksumAccumulator
          for (c <- s){
            println(c+" "+c.toByte)
            acc.add(c.toByte)}
          val cs = acc.checksum()
          println(cs)
          cache += (s -> cs)
          println(cache)
          cs
        }
    }

    def main(args: Array[String]) {
      val sum = ChecksumAccumulator.calculate("hello")
      val sum2 = ChecksumAccumulator.calculate("hello")

      println("sum [" + sum + "]")
      println("sum2 [" + sum2 + "]")
    }
  }
