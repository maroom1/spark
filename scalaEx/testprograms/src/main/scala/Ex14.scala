package com.edu

class Dog

package people {
class Person2 {
  val dogs = new scala.collection.mutable.ArrayBuffer[Dog]
  def description = "A person with " + dogs.length + " dogs"    
}

}
object Ex14ex  {
  def main(args:Array[String]){  
    val fre = new people.Person2
  fre.dogs += new Dog 
  fre.dogs += new Dog
  println(fre.description)}
}

