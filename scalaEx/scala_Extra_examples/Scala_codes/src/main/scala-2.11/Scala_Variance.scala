/**
  * Created by Goduguluri on 6/21/2016.
  */
object Scala_Variance extends App{

  var arr1 = new Array[Int](3)
  var arr2: Array[Any] = null
  //arr2 = arr1 // Compilation ERROR

  //to overcome above error we do as belo lower bounds,upper bounds etc

  class Pet(val name: String) {
    override def toString() = name
  }
  class Dog(override val name: String) extends Pet(name)
  def workWithPets(pets: Array[Pet]) {}

  val dogs = Array(new Dog("Rover"), new Dog("Comet"))

//  workWithPets(dogs) // Compilation ERROR

  // same as above


  def playWithPets[T <: Pet](pets: Array[T]) =
    println("Playing with pets: " + pets.mkString(", "))

/*  ----->Remember
  The ability to send a collection of subclass instances to a collection of
  base class is called covariance. And the ability to send a collection of
    superclass instances to a collection of subclass is called contravariance.
*/


/*
      . T <: Pet
  indicates that the class represented by T is derived from Pet. By using
    this syntax for the upper bound,6 we’re telling Scala that the parameterized
  type T of the parameter array must be at least an array of Pet but
    can be an array of any class derived from Pet. So, now we are allowed
    to make the following call:
*/


  playWithPets(dogs) //success
/*
  s. We can write a method named
    copy( ) that accepts two parameters of type Array[Pet]. However, that will
    not help us send an array of Dogs. Furthermore, we can copy from an
  array of Dogs into an array of Pets. In other words, the receiving array
  can be a collection of supertypes of the class of the source array. What
  we need is a lower bound:*/

  def copyPets[S, D >: S](fromPets: Array[S], toPets: Array[D]) = { //...
  } // here type D(PET) is super type of S(DOG)

  val pets = new Array[Pet](10)
  copyPets(dogs, pets)
/*
  collection of derived to be treated as a collection of base. You can do
  this by marking your parameterized type as +T instead of T, as in the
  following example:*/
  class MyList[+T] //...
  var list1 = new MyList[Int]
  var list2 : MyList[Any] = null
  list2 = list1 // OK
/*
  , +T tells Scala to allow covariance; in other words, during type
  checking, it asks Scala to accept a type or its base type. So, we’re able
    to assign a MyList[Int] to MyList[Any]. Remember, this was not possible for
  Array[Int].
  ----

    you can ask Scala to support contravariance on your types
using -T instead of T for parameterized types.
  */








}
