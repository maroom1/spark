name := "Server Log Analysis"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq (
"org.apache.spark" %% "spark-core" % "1.5.2",
"org.apache.spark" %% "spark-streaming" % "1.5.2",
"org.apache.spark" %% "spark-mllib" % "1.5.2"
)

libraryDependencies += "org.apache.spark" % "spark-hive_2.10" % "1.5.2"

libraryDependencies += "org.apache.spark" % "spark-streaming-twitter_2.10" % "1.5.2"

libraryDependencies += "org.twitter4j" % "twitter4j-core" % "4.0.4"

libraryDependencies += "org.twitter4j" % "twitter4j" % "4.0.4"

resolvers += Resolver.url("bintray-sbt-plugins", url("http://dl.bintray.com/sbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.0")
