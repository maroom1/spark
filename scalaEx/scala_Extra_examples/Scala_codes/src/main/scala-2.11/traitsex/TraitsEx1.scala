package traitsex

/**
  * Created by Goduguluri on 6/21/2016.
  */
object TraitsEx1 extends App{


  class Human(val name: String) {
    def listen() = println("Your friend " + name + " is listening")
  }

  class Man(override val name: String) extends Human(name)
  class Woman(override val name: String) extends Human(name)


  new Man("Alex") listen

  new Woman("jessie") listen



}
