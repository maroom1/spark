package com.ex

/**
  * Created by Goduguluri on 6/17/2016.
  */

// I got an error object Basic3 already exits as object Basics ... for this we have to change the settings
// file->settings --- scala compiler ---- incrementality = sbt

object Basic3 extends App{

  val greet=new Array[String](3)
  greet.update(0,"Hello")
  greet(1)=","
  greet(2)="World"

 for (i <- 0 to (greet.length-1) )
  println(greet(i))
 val num=Array("one","two")
 println(num.toList)
 val num1=Array.apply("1","2","3")
  println(num1.toList)
println(num1) //Array wont print the values  we have to specify the index
  val oneTwoThree = List(1, 2, 3)
  println("oneTwoThree [" + (oneTwoThree) + "]")

  { //maintain oneline gap so that compiler wont recognise correctly
    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)
    val oneTwoThreeFour = oneTwo ::: threeFour
    println(""+ oneTwo +" and "+ threeFour +" were not mutated.")
    println("Thus, "+ oneTwoThreeFour +" is a new list.")
  }
  {
    val twoThree = List(2, 3)
    val oneTwoThree = 1 :: twoThree
    println(oneTwoThree)
  }

  {
    val oneTwoThree = 1 :: 2 :: 3 :: Nil
    println(oneTwoThree)
  }

  val pair = (99, "Luftballons")
  println(pair._1)
  println(pair._2)

  var jetSet = Set("Boeing", "Airbus")
  jetSet += "Lear"
  println(jetSet.contains("Cessna"))
  jetSet = jetSet + "Lear"
  println("jetSet [" + (jetSet) + "]")

 import scala.collection.mutable.Set
  val movieSet = Set("Hitch", "Poltergeist")
  movieSet += "Shrek"
  println(movieSet)
  movieSet+="Shrek"
println(movieSet)

  import scala.collection.immutable.HashSet
  val hashSet = HashSet("Tomatoes", "Chilies")
   // hashSet += "Tamatoes" -- error
  println(hashSet + "Coriander")

  import scala.collection.mutable.Map

  val treasureMap = Map[Int, String]()
  treasureMap += (1 -> "Go to island.")
  treasureMap += (2 -> "Find big X on ground.")
  treasureMap += (3 -> "Dig.")
  println(treasureMap(2))

  val romanNumeral = Map(
    1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
  )
  println(romanNumeral(4))

  def printArgs(args: Array[String]): Unit = {
    var i = 0
    while (i < args.length) {
      println(args(i))
      i += 1
    }
  }
  printArgs(Array("zero", "one", "two"))

  {
    def printArgs(args: Array[String]): Unit = {
      for (arg <- args)
        println(arg)
    }
    printArgs(Array("three", "four", "five"))
  }

  {
    def printArgs(args: Array[String]): Unit = {
      args.foreach(println)
    }
    printArgs(Array("six", "seven", "eight"))
  }

  def formatArgs(args: Array[String]) = args.mkString("\n")
  val args1 = Array("nine", "ten")

  println(formatArgs(args1))

  val res = formatArgs(Array("zero", "one", "two"))
   assert(res == "zero\none\ntwo")  // true - so no error
 // assert(false) -- we passed false so we got an assertionError
  println("whew")

}
