name := "kafka-spark-sample"

version := "0.1"

scalaVersion := "2.11.12"

mainClass in (Compile,run) := Some("com.main.sample.MainClass")

libraryDependencies += "org.apache.kafka" % "kafka_2.11" % "2.4.1"
libraryDependencies += "org.apache.kafka" % "kafka-streams-scala_2.11" % "2.4.1"
libraryDependencies += "org.apache.spark" % "spark-streaming-kafka-0-10_2.11" % "2.4.6"
libraryDependencies += "org.apache.spark" % "spark-sql-kafka-0-10_2.11" % "2.4.6"
libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.4.6"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.4.6"
libraryDependencies += "org.apache.spark" % "spark-streaming_2.11" % "2.4.6"
libraryDependencies += "org.elasticsearch" % "elasticsearch-spark-20_2.11" % "7.8.0"