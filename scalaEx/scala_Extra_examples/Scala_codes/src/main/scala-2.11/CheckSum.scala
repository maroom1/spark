/**
  * Created by Goduguluri on 6/18/2016.
  */
object Ex1 {
  class ChecksumAccumulator {
    var sum = 0
  }

  def main(args: Array[String]) {
    val calc = new ChecksumAccumulator

    println("calc.sum [" + calc.sum + "]")

    val calc1 = new ChecksumAccumulator1
    calc1.add(2)

    println("calc.checksum [" + calc1.checksum1 + "]")
  }

  class ChecksumAccumulator1 {

    private var sum = 0

    def add(b: Byte): Unit = {
      sum += b
    }

    def checksum1(): Int = {
      println("--"+ (0xFF))
      println("~sum "+ ~sum)
      println(" * "+(sum&0xFF))
      println(" ~ "+(~(sum&0xFF)))

      return ~(sum & 0xFF) + 1
    }
  }






}
/*
*
  val acc = new ChecksumAccumulator
  val csa = new ChecksumAccumulator


  acc.sum = 3


  // Won't compile, because acc is a val
  acc = new ChecksumAccumulator


  class ChecksumAccumulator {
    private var sum = 0
  }


  val acc = new ChecksumAccumulator
  acc.sum = 5 // Won't compile, because sum is private

*
*
* */