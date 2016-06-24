/**
  * Created by Goduguluri on 6/24/2016.
  */
class CanaryTest extends org.scalatest.Suite {
  def testOK() {
    assert(true)
  }
}
(new CanaryTest).execute()

/*
D:\git_work\spark\scalaEx\scala_Extra_examples\Scala_codes\src\test\scala-2.11>s
cala -classpath D:\git_work\spark\hadoop_spark_jars\scalatest_2.11-2.2.6.jar Can
  aryTest.scala

Unfortunately Suite has been deprecated as a style trait. Please use trait Spec
instead.
←[32mMain$$anon$1$CanaryTest:←[0m
←[32m- testOK←[0m
*/
