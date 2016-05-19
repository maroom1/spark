name := "Word Counter"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "1.6.1"

libraryDependencies += "org.apache.hadoop" % "hadoop-streaming" % "2.7.1"

assemblyJarName in assembly := s"${name.value.replace(' ','-')}-${version.value}.jar"

assemblyOption in assembly := (assemblyOption in assembly).
                                    value.copy(includeScala = false)
									