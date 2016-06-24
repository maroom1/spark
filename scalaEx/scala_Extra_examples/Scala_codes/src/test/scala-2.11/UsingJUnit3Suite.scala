/**
  * Created by Goduguluri on 6/24/2016.
  */
class UsingJUnit3Suite extends org.scalatest.junit.JUnit3Suite {
  def withList(testFunction : (java.util.ArrayList[Integer]) => Unit) {
    val list = new java.util.ArrayList[Integer]
    try {
      testFunction(list)
    }
    finally {
      // perform any necessary cleanup here after return
    }
  }
  def testListEmptyOnCreate() {
    withList { list => expect(0, "Expected size to be 0") { list.size() } }
  }
  def testGetOnEmptyList() {
    withList {
      list => intercept[IndexOutOfBoundsException] { list.get(0) }
    }
  }
}


