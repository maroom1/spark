class Rational(n: Int, d: Int) {
  println("Created "+ n +"/"+ d)
}

object Main {
  def main(args: Array[String]) {
    new Rational(1, 2)
  }
}

Main.main(Array(""))


class Rational1(n: Int, d: Int) {
require(d!=0," denominator cannot be empty")
  override def toString = n +"/"+ d
}

object Main1 {
  def main(args: Array[String]) {
    println(new Rational1(1, 3))
    println
    println(new Rational1(5, 7))
    println
    println(new Rational1(5, 0))
  }
}

Main1.main(Array(""))

