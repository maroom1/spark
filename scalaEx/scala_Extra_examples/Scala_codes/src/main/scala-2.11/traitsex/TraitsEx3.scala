package traitsex

/**
  * Created by Goduguluri on 6/21/2016.
  */
object TraitsEx3 extends App{

  println("running program "+ getClass.getName +"\n")

  class Animal

  trait Friend {
    val name: String
    def listen() = println("Your friend " + name + " is listening")
  }

  class Human(val name: String) extends Friend

  class Man(override val name: String) extends Human(name)

  class Woman(override val name: String) extends Human(name)

  class Dog(val name: String) extends Animal with Friend {
    //optionally override method here.
    override def listen = println(name + "'s listening quietly")
  }
  val john = new Man("John")
  val sara = new Woman("Sara")
  val comet = new Dog("Comet")
  john.listen
  sara.listen
  comet.listen



  val mansBestFriend : Friend = comet // we can use type Animal but listen is present in Friend
  mansBestFriend.listen


  def helpAsFriend(friend: Friend) = friend listen

  helpAsFriend(sara)
  helpAsFriend(comet)

  class Cat(val name: String) extends Animal

  def useFriend(friend: Friend) = friend listen

  val alf = new Cat("Alf")
 // val friend : Friend = alf // ERROR becoz cat is not extending friend  and we are trying to assign to some type which is not super or derived class

 // useFriend(alf) // ERROR

  val snowy = new Cat("Snowy") with Friend

  val friend : Friend = snowy
  friend.listen

  useFriend(snowy)


}
