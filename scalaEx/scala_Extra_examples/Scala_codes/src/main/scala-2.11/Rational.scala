/**
  * Created by Goduguluri on 6/19/2016.
  */
class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  println("g "+g)
  val numer: Int = n/g
  val denom: Int = d/g
  def this(n: Int) = this(n, 1) // auxiliary constructor

  override def toString = numer +"/"+ denom
  def add(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  def + (that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def + (i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def - (that: Rational): Rational =
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )

  def - (i: Int): Rational =
    new Rational(numer - i * denom, denom)

  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def * (i: Int): Rational =
    new Rational(numer * i, denom)

  def / (that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  def / (i: Int): Rational =
    new Rational(numer, denom * i)

  def lessThan(that: Rational) =
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) =
    if (this.lessThan(that)) that else this

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  /*
  * 12-20
  *   20 12
  *   12 8
  *   8 4
  *   4 0
  *   4
  * */
}

object RationalEx {
  def main(args: Array[String]) {
    val oneHalf = new Rational(1, 2)
    val twoThirds = new Rational(2, 3)
    val sum = oneHalf add twoThirds //oneHalf.add(twoThirds)

    println("oneHalf [" + oneHalf + "]")
    println("twoThirds [" + twoThirds + "]")
    println("sum [" + sum + "]")
    println("sum.numer [" + sum.numer + "]")
    println("sum.denom [" + sum.denom + "]")


    println("oneHalf.lessThan(twoThirds) [" + oneHalf.lessThan(twoThirds) + "]")
    println("oneHalf.max(twoThirds) [" + oneHalf.max(twoThirds) + "]")

    val z = new Rational(3)
    println("y [" + z + "]")

    println("new Rational(66, 42) [" + new Rational(12, 20) + "]")


    println("-----------------------------------")
    var x = new Rational(1, 2)
    var y = new Rational(2, 3)
    println("x [" + x + "]")
    println("y [" + y + "]")
    println("x + y [" + (x + y) + "]")
    println("x.+(y) [" + (x.+(y)) + "]")
    println("x + x * y [" + (x + x * y) + "]")
    println("(x + x) * y [" + ((x + x) * y) + "]")
    println("x + (x * y) [" + (x + (x * y)) + "]")

 println("--------------------------")
    val x1 = new Rational(2, 3)
    println("x1 [" + x1 + "]")
    println("x1 * x1 [" + (x1 * x1) + "]")
    println("x1 * 2 [" + (x1 * 2) + "]")

    implicit def intToRational(x: Int) = new Rational(x)
    val r = new Rational(2,3)
    println("2 * r [" + (2 * r) + "]")


  }
}