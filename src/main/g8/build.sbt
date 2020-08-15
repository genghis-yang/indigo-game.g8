ThisBuild / scalaVersion := "$scala_version$"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "$organization$"

val IndigoVersion = "$indigo_version$"
val Specs2Version = "$specs2_version$"

lazy val root = (project in file("."))
  .enablePlugins(ScalaJSPlugin, SbtIndigo) // Enable the Scala.js and Indigo plugins
  .settings(
    name := "$name;format="norm"$",
    libraryDependencies ++= Seq(
      "io.indigoengine" %%% "indigo"             % IndigoVersion,
      "io.indigoengine" %%% "indigo-json-circe"  % IndigoVersion, 
      "org.specs2"      %%  "specs2-core"        % Specs2Version % "test",
    ),
    // Indigo Special Settings
    showCursor := true,
    title := "$name$",
    gameAssetsDirectory := "src/main/resources/assets"
  )

addCommandAlias("buildGame", ";compile;fastOptJS;indigoBuildJS")
addCommandAlias("publishGame", ";compile;fullOptJS;indigoPublishJS")
