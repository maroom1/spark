echo off
echo "--->Creating scala sbt project to import into scala"
mkdir %1 
cd %1
mkdir src
cd src
mkdir main
mkdir test
cd main
mkdir java
mkdir scala
cd ../test
mkdir java
mkdir scala
cd ..
cd ..
echo name := "%2" >> build.sbt
echo. >> build.sbt
echo version := "0.1" >> build.sbt
echo. >> build.sbt
echo scalaVersion := "2.11.8" >> build.sbt
echo.
mkdir project
cd project
echo sbt.version = 0.13.11 >> build.properties
SET var=addSbtPlugin("com.typesafe.sbteclipse" %% "sbteclipse-plugin" %% "4.0.0")
echo %var% >> plugins.sbt
cd ..
sbt eclipse



