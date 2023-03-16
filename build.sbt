name := """enfore"""
organization := "com.enfore"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.10"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.enfore.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.enfore.binders._"


libraryDependencies ++= {
  Seq(
    "com.opencsv" % "opencsv"      % "4.1",
    "com.typesafe.play" % "play-json-joda_2.13" % "2.9.4"
  )
}