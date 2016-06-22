/**
  * Created by Goduguluri on 6/20/2016.
  */
//getters and setters will be created autotically
class Publication(val title: String){println("1")}
class Book(title: String) extends Publication(title){println(2)}

object Library {
  println(3)
  val books: Set[Book] =
    Set(
      new Book("Programming in Scala"),
      new Book("Walden")
    )
  println(4)

  def printBookList(info: Book => AnyRef) {// we can write Publication because Book extends publication
    println(5)

    for (book <- books) println(info(book))
  }
}

object Customer extends App {
  def getTitle(p: Publication): String ={ println(6);p.title}
    Library.printBookList(getTitle)
}
