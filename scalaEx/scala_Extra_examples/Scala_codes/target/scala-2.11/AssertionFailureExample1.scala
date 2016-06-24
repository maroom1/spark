/**
  * Created by Goduguluri on 6/24/2016.
  */
class AssertionFailureWithMessage1 extends org.scalatest.Suite {
  def testAssertFailure() {
    assert(2 === List().size, "Unexpected size of List")
  }
}
(new AssertionFailureWithMessage).execute()


/*

D:\git_work\spark\scalaEx\scala_Extra_examples\Scala_codes\src\test\scala-2.11>s
cala -classpath D:\git_work\spark\hadoop_spark_jars\scalatest_2.11-2.2.6.jar Ass
  ertionFailureExample.scala
Unfortunately Suite has been deprecated as a style trait. Please use trait Spec
instead.
←[32mMain$$anon$1$AssertionFailureExample:←[0m
←[31m- testAssertFailure *** FAILED ***←[0m
←[31m  2 did not equal 0 (AssertionFailureExample.scala:6)←[0m*/
