import scala.io.Source


object Ex5 {
  def main(args: Array[String]) {
   // val curDir = System.getProperty("user.dir")
   // print(curDir) - for debugging

    def countchars3(args: Array[String]) {
      def widthOfLength(s: String) = s.length.toString.length

      if (args.length > 0) {
        val lines = Source.fromFile(args(0)).getLines.toList
        println(lines + "---")
        val longestLine = lines.reduceLeft(
          (a, b) => if (a.length > b.length) a else b
        )
        println(longestLine+"-----")
        val maxWidth = widthOfLength(longestLine)
        println(maxWidth+"-------")
        for (line <- lines) {
          val numSpaces = maxWidth - widthOfLength(line)
          val padding = " " * numSpaces
          println(padding + line.length +" | "+ line)
        }
      }
    }
   countchars3(Array("sbt.xml"))
  }
}

/*
* D:\git_work\spark\scalaEx\scala_Extra_examples\Scala_codes\src\main\scala-2.11>s
calac ReadLines2.scala

D:\git_work\spark\scalaEx\scala_Extra_examples\Scala_codes\src\main\scala-2.11>s
cala Ex5 ReadLines.scala
 0 | 16 | //package com.ex 0 | 22 | import scala.io.Source30 | object ReadLines
extends App {19 | if(args.length > 0)48 |   for(line <- Source.fromFile(args(0))
.getLines)35 |     println(line.length +" "+ line) 5 |  else48 |     Console.err
.println("Please enter filename") 1 | } 2 | /* 1 | *80 | D:\git_work\spark\scala
Ex\scala_Extra_examples\Scala_codes\src\main\scala-2.11>s21 | calac ReadLines.sc
ala 0 | 80 | D:\git_work\spark\scalaEx\scala_Extra_examples\Scala_codes\src\main
\scala-2.11>s27 | cala ReadLines Basic1.scala17 | 14 package com.ex 1 | 0 5 | 3
/**42 | 39   * Created by Goduguluri on 6/17/2016. 6 | 4   */18 | 15 object Basi
c1 {36 | 33   def main(args: Array[String]) {50 | 47     val big = new java.math
.BigInteger("12345")37 | 34     println("big [" + (big) + "]")46 | 43     val gr
eetStrings = new Array[String](3)32 | 29     greetStrings(0) = "Hello"29 | 26
  greetStrings(1) = ", "35 | 32     greetStrings(2) = "world!\n"60 | 57     (0 t
o 2).foreach { case i => print(greetStrings(i)) } 5 | 3   } 3 | 1 } 0 | 79 | D:\
git_work\spark\scalaEx\scala_Extra_examples\Scala_codes\src\main\scala-2.11> 0 |
  4 | * */
D:\git_work\spark\scalaEx\scala_Extra_examples\Scala_codes\src\main\scala-2.11>

*
* */