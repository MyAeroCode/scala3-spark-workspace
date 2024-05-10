scalaVersion := "2.12.19"

val sparkVersion = "3.5.1"
val glueVersion  = "4.0.0" 
val scalaTestVersion = "3.2.18"

lazy val root = project
  .in(file("."))
  .settings(
    name := "002-hello-glue",

    resolvers ++= Seq(
      "aws-glue-etl-artifacts" at "https://aws-glue-etl-artifacts.s3.amazonaws.com/release/"
    ),

    libraryDependencies ++= Seq(
      ("com.amazonaws" % "AWSGlueETL" % glueVersion),
      ("org.apache.spark" %% "spark-sql" % sparkVersion),
      ("org.apache.spark" %% "spark-core" % sparkVersion),
      ("org.scalactic" %% "scalactic" % "3.1.1") % Test,
      ("org.scalatest" %% "scalatest" % "3.1.1") % Test,
      ("org.scalamock" %% "scalamock" % "6.0.0") % Test
    )
  )

Compile / run := Defaults.runTask(Compile / fullClasspath, Compile / run / mainClass, Compile / run / runner).evaluated