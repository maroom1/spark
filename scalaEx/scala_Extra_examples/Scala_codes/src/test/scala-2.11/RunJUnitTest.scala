/**
  * Created by Goduguluri on 6/24/2016.
  */
object RunJUnitTest {
  def main(args: Array[String]) =
    junit.textui.TestRunner.run(classOf[UsingJUnit3Suite])
}

/*
D:\git_work\spark\scalaEx\scala_Extra_examples\Scala_codes\src\test\scala-2.11>s
cala -classpath "D:\git_work\spark\hadoop_spark_jars\scalatest_2.11-2.2.6.jar;D:
\git_work\spark\hadoop_spark_jars\junit-4.11.jar" org.scalatest.tools.Runner -o
  -p . -s UsingJUnit3Suite
  WARNING: -p has been deprecated and will be reused for a different (but still ve
  ry cool) purpose in ScalaTest 2.0. Please change all uses of -p to -R.
  ←[36mRun starting. Expected test count is: 2←[0m
  ←[32mUsingJUnit3Suite:←[0m
  ←[32m- testGetOnEmptyList(UsingJUnit3Suite)←[0m
  ←[32m- testListEmptyOnCreate(UsingJUnit3Suite)←[0m
  ←[36mRun completed in 170 milliseconds.←[0m
  ←[36mTotal number of tests run: 2←[0m
  ←[36mSuites: completed 1, aborted 0←[0m
  ←[36mTests: succeeded 2, failed 0, canceled 0, ignored 0, pending 0←[0m
  ←[32mAll tests passed.←[0m*/
