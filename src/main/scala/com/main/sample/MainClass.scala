package com.main.sample

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.elasticsearch.hadoop.cfg.ConfigurationOptions

object MainClass {

  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder()
      .config(ConfigurationOptions.ES_NODES, "127.0.0.1")
      .config(ConfigurationOptions.ES_PORT, "9200")
      .master("local[*]")
      .appName("sample-structured-streaming")
      .getOrCreate()

    val sparkDF = sparkSession
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "localhost:9092")
      .option("subscribe", "spark-check")
      .option("auto.offset.reset", "latest")
      .option("group.id", "consumer-group-0")
      .option("failOnDataLoss","false")
      .load()

    val infoDF = sparkDF.selectExpr( "CAST(value AS STRING)"  )

    infoDF.writeStream
      .outputMode("append")
      .format("org.elasticsearch.spark.sql")
      .option("checkpointLocation", "C:\\Users\\surbhi.mishra\\AppData\\Local\\Temp\\new_spark")
      .start("kafka-consumer-messages/doc-type")
      .awaitTermination()

  }
}
