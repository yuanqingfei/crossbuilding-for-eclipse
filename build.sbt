//import NativePackagerKeys._


lazy val app = crossProject.in(file("."))
  .settings(
  unmanagedSourceDirectories in Compile +=
    baseDirectory.value  / "shared" / "main" / "scala",
  libraryDependencies ++= Seq(
    "com.lihaoyi" %%% "scalatags" % "0.4.6",
    "com.lihaoyi" %%% "upickle" % "0.2.7"
  ),
  scalaVersion := "2.11.7"
//  name := "app"
).jsSettings(
  name := "appJs-pro",
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.0"
  )
).jvmSettings(
  name := "appJvm-pro",
  libraryDependencies ++= Seq(
    "io.spray" %% "spray-can" % "1.3.2",
    "io.spray" %% "spray-routing" % "1.3.2",
    "com.typesafe.akka" %% "akka-actor" % "2.3.6"
  )
)

lazy val appJS = app.js
lazy val appJVM = app.jvm
.settings(
  (resources in Compile) += (fastOptJS in (appJS, Compile)).value.data
)

//EclipseKeys.useProjectId := true

//EclipseKeys.skipParents in ThisBuild := true

