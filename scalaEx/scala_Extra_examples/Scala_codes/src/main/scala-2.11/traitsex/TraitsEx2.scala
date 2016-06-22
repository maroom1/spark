package traitsex

/**
  * Created by Goduguluri on 6/21/2016.
  */
object TraitsEx2 extends App{
 println("running program "+ getClass.getName +"\n")

  trait Friend {
    val name: String
    def listen() = println("Your friend " + name + " is listening")
  }

  class Human(val name: String) extends Friend

  class Man(override val name: String) extends Human(name)

  class Woman(override val name: String) extends Human(name)

new Man("Alex") listen()

  new Woman("jessie") listen()

}
