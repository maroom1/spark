package scalaxml
import scala.xml._
/**
  * Created by Goduguluri on 6/19/2016.
  */
object Misc {

  val therm = new CCTherm {
    val description = "hot dog #5"
    val yearMade = 1952
    val dateObtained = "March 14, 2006"
    val bookPrice = 2199
    val purchasePrice = 500
    val condition = 9
  }

  val node = therm.toXML

  def main(args: Array[String]) {
    println("node [" + node + "]")
    scala.xml.XML.save("therm1.xml", node)
    val loadnode = xml.XML.loadFile("therm1.xml")
    println("loadnode [" + loadnode + "]")
    println("CCTherm.fromXML(loadnode) [" + CCTherm.fromXML(loadnode) + "]")
  }
}
