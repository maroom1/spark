/**
  * Created by Goduguluri on 6/24/2016.
  */
class UsingFunSuite extends org.scalatest.FunSuite {
  def withList(testFunction : (java.util.ArrayList[Integer]) => Unit) {
    val list = new java.util.ArrayList[Integer]
    try {
      testFunction(list)
    }
    finally {
      // perform any necessary cleanup here after return
    }
  }
  test("Check if the list is Empty On Creation") {
    withList { list => expect(0, "Expected size to be 0") { list.size() } }
  }
  test("Get must throw exception when called on an empty list") {
    withList {
      list => intercept[IndexOutOfBoundsException] { list.get(0) }
    }
  }
}
(new UsingFunSuite).execute()
