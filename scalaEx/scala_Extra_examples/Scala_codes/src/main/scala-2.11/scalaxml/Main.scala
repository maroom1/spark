package scalaxml

/**
  * Created by Goduguluri on 6/20/2016.
  */
import scala.xml._
import scala.xml.transform._

object Main extends App {

  import Stuff._

  val sourceXml = XML.loadFile("metadata.switchaai.xml")

  val allEntities = sourceXml \\ "EntityDescriptor"

  val wantedEntities = allEntities filter entitiesWeWant

  val strippedEntities = wantedEntities flatMap removeExtensions

  strippedEntities foreach printEntityToFile
}

object Stuff{

  private val wantedEntityNames = Seq("https://aai.unifr.ch/idp/shibboleth", "https://aai.unil.ch/idp/shibboleth")

  def entitiesWeWant(x: Node) = wantedEntityNames.contains((x \ "@entityID").text)

  def removeExtensions(x: Node) = new RuleTransformer(removeIt).transform(x)

  private def filenameFromEntity(x: Node) = {
    val entityName = (x \ "@entityID").text
    entityName.replace("https://", "").replace("/idp/shibboleth", "") + ".xml"
  }

  def printEntityToFile(x: Node) = {
    printToFile(new java.io.File(filenameFromEntity(x)))(p => {
      p.println("""<?xml version="1.0" encoding="UTF-8"?>""" + x)
    })
  }

  private def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
    val p = new java.io.PrintWriter(f)
    try { op(p) } finally { p.close() }
  }

  private val removeIt = new RewriteRule {
    override def transform(n: Node): NodeSeq = n match {
      case e: Elem if e.label == "Extensions" => NodeSeq.Empty
      case n => n
    }
  }
}