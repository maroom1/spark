package scalaxml
import java.io._
import scala.xml._
/**
  * Created by Goduguluri on 6/19/2016.
  */
object Book extends App{
val place=System.getProperty("user.dir")
  println(place)
 // val filesHere = (new java.io.File(".")).listFiles

//check the working directory in configuration
  val books= xml.XML.loadFile("book.xml")
 // println(books + "\n" +"----------------------")
  val booklist= books \ "book"
   val s= <catalog>{booklist}</catalog>
 // println(s.child)

  var s1= <catalog></catalog>
  //println(s1.child)
  //println(books \ "book" \ "title" text)
var b =s1.child

 for(book<-booklist){

  b = b ++ new BookClass( book \ "author" text ,book \ "title" text,book \ "genre" text,
     (book \ "price").text ,
     book \ "publish_date" text,
     book \ "description" text).toXML

}
 val bm=s1.copy(child = s1.child ++ b)
  if(!new java.io.File("bookie.xml").exists) {
    printf("writing")
    xml.XML.save("bookie.xml", s1.copy(child = s1.child ++ b))
  }
  //println(books text)
  //println(books \ "book" \ "title" text)



}
