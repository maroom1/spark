name := "Scala_codes"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.3"

// https://mvnrepository.com/artifact/org.scala-lang/scala-actors
libraryDependencies += "org.scala-lang" % "scala-actors" % "2.11.7"

libraryDependencies += "junit" % "junit" % "4.12"

libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.6"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.3"

libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "1.0.1"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
