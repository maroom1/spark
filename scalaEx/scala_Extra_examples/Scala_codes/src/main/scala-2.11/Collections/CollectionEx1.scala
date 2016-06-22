package Collections

/**
  * Created by Goduguluri on 6/21/2016.
  */
object CollectionEx1 extends App {
/*
  Scala’s main collections are List, Set, and Map. a
list is an ordered collection of objects, a set is an unordered collection,
and a map is a dictionary of key-value pairs. Scala favors immutable
collections, even though mutable versions are also provided*/
//default we used the immutable set

  val colors1 = Set("Blue", "Green", "Red")
  var colors = colors1
  println("colors1 (colors): " + colors)
  colors += "Black"
  println("colors: " + colors)
  println("colors1: " + colors1)

  //val colors2 = new scala.collection.immutable.Set3[String]("Blue", "Green", "Red") -- run in REPL

  val feeds1 = Set("blog.toolshed.com", "pragdave.pragprog.com",
    "pragmactic-osxer.blogspot.com", "vita-contemplativa.blogspot.com")
  val feeds2 = Set("blog.toolshed.com", "martinfowler.com/bliki")


  val blogSpotFeeds = feeds1 filter ( _ contains "blogspot" )
  println("blogspot feeds: " + blogSpotFeeds.mkString(", "))

  val mergedFeeds = feeds1 ++ feeds2
  println("# of merged feeds: " + mergedFeeds.size)

  val commonFeeds = feeds1 intersect feeds2
  println("common feeds: " + commonFeeds.mkString(", "))

  val urls = feeds1 map ( "http://" + _ )
  println("One url: " + urls)
  println("Refresh Feeds:")
  feeds1 foreach { feed => println(" Refreshing " + feed ) }









}
