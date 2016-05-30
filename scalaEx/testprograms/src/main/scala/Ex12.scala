package com {
  package edureka {
    package scala1 {
      class Employee(id: Int) {
        def description = "Employee id is: " + id
      }      
    }
  }
}

package org {
  package edureka {
    class Counter {
      private var value = 0 
      def increment() { value += 1 } 
      def description = "Counter Value is " + value
    }
  }
}

object Main12 extends App {
  val jay = new com.edureka.scala1.Employee(1729)
  val vishal = new com.edureka.scala1.Manager("Vishal")
  val myCounter = new org.edureka.Counter
  println(jay + ": " + jay.description)
  println(vishal + ": " + vishal.description)
  println(myCounter + ": " + myCounter.description)
}
