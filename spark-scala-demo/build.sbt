scalaVersion := "2.12.15"

name := "spark-scala-demo"
organization := "com.myspark"
version := "1.0"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.3.1"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.3.1"
libraryDependencies += "org.apache.spark" %% "spark-sql-kafka-0-10" % "3.3.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14" % Test

assembly / assemblyJarName  := "spark-scala-demo-1.0.jar"

assembly / assemblyMergeStrategy := {
  case PathList("META-INF","services",xs @ _*) => MergeStrategy.filterDistinctLines // Added this
  case PathList("META-INF",xs @ _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}