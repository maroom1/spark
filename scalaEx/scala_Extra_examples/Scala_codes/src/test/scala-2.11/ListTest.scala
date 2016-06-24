/**
  * Created by Goduguluri on 6/24/2016.
  */
class ListTest extends org.scalatest.Suite {
  def testListEmpty() {
    val list = new java.util.ArrayList[Integer]
    assert(0 == list.size)
  }
  def testListAdd() {
    val list = new java.util.ArrayList[Integer]
    list.add(1)
    list add 4
    assert(2 == list.size)
  }
}

/*

D:\git_work\spark\scalaEx\scala_Extra_examples\Scala_codes\src\test\scala-2.11>s
calac -classpath D:\git_work\spark\hadoop_spark_jars\scalatest_2.11-2.2.6.jar Li
  stTest.scala

D:\git_work\spark\scalaEx\scala_Extra_examples\Scala_codes\src\test\scala-2.11>s
cala -classpath D:\git_work\spark\hadoop_spark_jars\scalatest_2.11-2.2.6.jar org
.scalatest.tools.Runner -p . -o
  WARNING: -p has been deprecated and will be reused for a different (but still ve
  ry cool) purpose in ScalaTest 2.0. Please change all uses of -p to -R.
←[36mDiscovery starting.←[0m
←[36mDiscovery completed in 249 milliseconds.←[0m
←[36mRun starting. Expected test count is: 2←[0m
←[32mListTest:←[0m
  Unfortunately Suite has been deprecated as a style trait. Please use trait Spec
instead.
←[32m- testListAdd←[0m
←[32m- testListEmpty←[0m
←[36mRun completed in 376 milliseconds.←[0m
←[36mTotal number of tests run: 2←[0m
←[36mSuites: completed 2, aborted 0←[0m
←[36mTests: succeeded 2, failed 0, canceled 0, ignored 0, pending 0←[0m
←[32mAll tests passed.←[0m

D:\git_work\spark\scalaEx\scala_Extra_examples\Scala_codes\src\test\scala-2.11>*/


/*The -p option specifies the directories where Runner will look for test
suites. Since we did not specify any particular test suite, it will pick up
all compiled test suites in the given path.*/

