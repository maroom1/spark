package com.edureka.ex15

package object people {
  val defaultName = "John Q. Public"
}

package people {
  class Person {
    var name = defaultName // A constant from the package
    private[ex15] def description = "A person with name " + name
  }
}


object Main15 extends App {
  val john = new com.edureka.ex15.people.Person
  println(john.description)
}