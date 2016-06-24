package Collections

/**
  * Created by Goduguluri on 6/22/2016.
  */
object collectionList  extends App {


  val feeds = List("blog.toolshed.com", "pragdave.pragprog.com",
    "dimsumthinking.com/blog")


  println("First feed: " + feeds.head)
  println("Second feed: " + feeds(1))
  println("Second feed: " + feeds.tail)


  val prefixedList = "forums.pragprog.com/forums/87" :: feeds
  println("First Feed In Prefixed: " + prefixedList.head)

  val feedsWithForums =
    feeds ::: List("forums.pragprog.com/forums/87", "forums.pragprog.com/forums/55")
  println("First feed in feeds with forum: " + feedsWithForums.head)
  println("Last feed in feeds with forum: " + feedsWithForums.last)


  val appendedList = feeds ::: List("agiledeveloper.com/blog")
  println("Last Feed In Appended: " + appendedList.last)

  println("Feeds with blog: " + feeds.filter( _ contains "blog" ).mkString(", "))
  println("All feeds have com: " + feeds.forall( _ contains "com" ))
  println("All feeds have dave: " + feeds.forall( _ contains "dave" ))
  println("Any feed has dave: " + feeds.exists( _ contains "dave" ))
  println("Any feed has bill: " + feeds.exists( _ contains "bill" ))


  println("Feed url lengths: " + feeds.map( _.length ).mkString(", "))


  val total = feeds.foldLeft(0) { (total, feed) => total + feed.length }
  println("Total length of feed urls: " + total )

/*
  The method /:( ) is equivalent to foldLeft( ) and \:( ) to foldRight( ).
*/


  val total2 = (0 /: feeds) { (total, feed) => total + feed.length }
  println("Total length of feed urls: " + total2 )


  val total3 = (0 /: feeds) { _ + _.length }
  println("Total length of feed urls: " + total3 )

/*
  ^( ) is a
  method defined on the class Cow, while ^:( ) is a method defined on the
  class Moon:*/


  class Cow {
    def ^(moon: Moon) = println("Cow jumped over the moon")
  }
  class Moon {
    def ^:(cow: Cow) = println("This cow jumped over the moon too")
  }


  val cow = new Cow
  val moon = new Moon
  cow ^ moon
  cow ^: moon // moon.^:(cow) ok
/*
  In addition to operators that end with :, there are a set of operators that
  also are targeted at the instance that follow them. These are the unary
    operators +, -, !, and ~. The unary + maps over to a call to unary_+( ), the
  unary - to unary_-( ), and so on*/


  class Sample {
    def unary_+ = println("Called unary +")
    def unary_- = println("called unary -")
    def unary_! = println("called unary !")
    def unary_~ = println("called unary ~")
  }
  val sample = new Sample
  +sample
  -sample
  !sample
  ~sample

  for (i <- 1 to 3) { print("ho ") }

  val result = for (i <- 1 to 10)
    yield i * 2
// SAME AS
  val result2 = (1 to 10).map(_ * 2)

  val doubleEven = for (i <- 1 to 10; if i % 2 == 0)
    yield i * 2
//SAME AS
  for {
    i <- 1 to 10
    if i % 2 == 0
  }
    yield i * 2

  class Person(val firstName: String, val lastName: String)
  object Person {
    def apply(firstName: String, lastName: String) : Person =
      new Person(firstName, lastName)
  }


  val friends = List(Person("Brian", "Sletten"), Person("Neal", "Ford"),
    Person("Scott", "Davis"), Person("Stuart", "Halloway"))

  val lastNames = for (friend <- friends; lastName = friend.lastName) yield lastName

  println(lastNames.mkString(", "))


  for (i <- 1 to 3; j <- 4 to 6) {
    print("[" + i + "," + j + "] ")
  }




}
