package com.ex

/**
  * Created by Goduguluri on 6/17/2016.
  */
object Basic1 {
  def main(args: Array[String]) {
    val big = new java.math.BigInteger("12345")
    println("big [" + (big) + "]")
    val greetStrings = new Array[String](3)
    greetStrings(0) = "Hello"
    greetStrings(1) = ", "
    greetStrings(2) = "world!\n"
    (0 to 2).foreach { case i => print(greetStrings(i)) }
  }
}
