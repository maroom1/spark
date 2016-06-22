object Ex3 {
  class ChecksumAccumulator {
     private var sum = 0
    def add(b: Byte): Unit = sum += b
    def checksum(): Int = ~(sum & 0xFF) + 1
  }

  def main(args: Array[String]) {
    val calc = new ChecksumAccumulator

    calc.add(3)

    println("calc.checksum [" + calc.checksum + "]")
  }
}