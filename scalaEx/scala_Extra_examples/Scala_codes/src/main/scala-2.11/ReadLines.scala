
//package com.ex

import scala.io.Source
object ReadLines extends App {
if(args.length > 0)
  for(line <- Source.fromFile(args(0)).getLines)
    println(line.length +" "+ line)
 else
    Console.err.println("Please enter filename")
}
/*
*
D:\git_work\spark\scalaEx\scala_Extra_examples\Scala_codes\src\main\scala-2.11>s
calac ReadLines.scala

D:\git_work\spark\scalaEx\scala_Extra_examples\Scala_codes\src\main\scala-2.11>s
cala ReadLines Basic1.scala
14 package com.ex
0
3 /**
39   * Created by Goduguluri on 6/17/2016.
4   */
15 object Basic1 {
33   def main(args: Array[String]) {
47     val big = new java.math.BigInteger("12345")
34     println("big [" + (big) + "]")
43     val greetStrings = new Array[String](3)
29     greetStrings(0) = "Hello"
26     greetStrings(1) = ", "
32     greetStrings(2) = "world!\n"
57     (0 to 2).foreach { case i => print(greetStrings(i)) }
3   }
1 }

D:\git_work\spark\scalaEx\scala_Extra_examples\Scala_codes\src\main\scala-2.11>

* */