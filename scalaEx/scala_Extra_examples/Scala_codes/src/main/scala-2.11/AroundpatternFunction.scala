/**
  * Created by Goduguluri on 6/21/2016.
  */
object AroundpatternFunction extends App{

  class Resource private() {
    println("Starting transaction...")
    private def cleanUp() { println("Ending transaction...") }
    def op1 = println("Operation 1")
    def op2 = println("Operation 2")
    def op3 = println("Operation 3")
  }
  object Resource {
    def use(codeBlock: Resource => Unit) {
      val resource = new Resource
      try {
        codeBlock(resource)
      }
      finally {
        resource.cleanUp()
      }
    }
  }

  Resource.use { resource =>
    resource.op1
    resource.op2
    resource.op3
    resource.op1
  }

  import java.io._
  def writeToFile(fileName: String)(codeBlock : PrintWriter => Unit) = {
    val writer = new PrintWriter(new File(fileName))
    try { codeBlock(writer) } finally { writer.close() }
  }

  writeToFile("output.txt") { writer =>
    writer write "hello from Scala"
  }

}
