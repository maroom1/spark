/**
  * Created by Goduguluri on 6/24/2016.
  */
class testGetOn extends org.scalatest.Suite{


  def testGetOnEmptyList() {
    try {
      val list = new java.util.ArrayList[Integer]
      list.get(0)
      fail("Expected exception for getting element from empty list")
    }
    catch {
      case ex: IndexOutOfBoundsException => // :) Success
    }
  }

 /* def testGetOnEmptyList_Concise() {
    val list = new java.util.ArrayList[Integer]
    intercept(classOf[IndexOutOfBoundsException],
      "Expected exception for getting element from empty list") { }

    //You'll get a deprecation warning from the statement above.
    //ScalaTest is evolving to use a newer style for intercept.
    //Currently the new style does not take an error message argument.
    //When it does, you should use
    //intercept[IndexOutOfBoundsException] ("Expected ...") {...}
  }*/



}

(new testGetOn).execute()