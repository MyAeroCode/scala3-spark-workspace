scalaVersion := "3.4.1"

val sparkVersion = "3.5.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "001-hello-spark",

    libraryDependencies ++= Seq(
      ("org.apache.spark" %% "spark-sql" % sparkVersion).cross(CrossVersion.for3Use2_13) % "provided",
      ("org.apache.spark" %% "spark-core" % sparkVersion).cross(CrossVersion.for3Use2_13) % "provided"
    )
  )

Compile / run := Defaults.runTask(Compile / fullClasspath, Compile / run / mainClass, Compile / run / runner).evaluated