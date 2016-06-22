package Collections

/**
  * Created by Goduguluri on 6/21/2016.
  */
object CollectionsMap extends App{


  val feeds = Map("Andy Hunt" -> "blog.toolshed.com",
    "Dave Thomas" -> "pragdave.pragprog.com",
    "Dan Steinberg" -> "dimsumthinking.com/blog")

  val filterNameStartWithD = feeds filterKeys( _ startsWith "D" )
  println("# of Filtered: " + filterNameStartWithD.size)


  val filterNameStartWithDAndBlogInFeed = feeds filter { element =>
    val (key, value) = element
    (key startsWith "D") && (value contains "blog")
  }
  println("# of feeds with auth name D* and blog in URL: " +
    filterNameStartWithDAndBlogInFeed.size)


  println("Get Andy's Feed: " + feeds.get("Andy Hunt"))
  println("Get Bill's Feed: " + feeds.get("Bill Who"))

  try {
    println("Get Andy's Feed Using apply(): " + feeds("Andy Hunt"))
    print("Get Bill's Feed: ")
    println(feeds("Bill Who"))
  }
  catch {
    case ex : java.util.NoSuchElementException => println("Not found")
  }

  
}
