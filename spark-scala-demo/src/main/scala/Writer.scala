import SparkStreaming.{checkpointPath}
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.streaming.Trigger

object Writer {

  def writeStreamToFile(df: DataFrame, path:String) = {
    df
      .writeStream
      .trigger(Trigger.ProcessingTime("20 seconds"))
      .outputMode("complete")
      .format("csv") // supports these formats : csv, json, orc, parquet
      .option("path", path)
      .option("header", true)
      .option("checkpointLocation", checkpointPath)
      .start()
      .awaitTermination()
  }

  def writeStreamToConsole(df: DataFrame) = {
    df
      .writeStream
      .trigger(Trigger.ProcessingTime("20 seconds"))
      .outputMode("complete")
      .format("console")
      .option("truncate", false)
      .option("numRows", 3)
      .option("checkpointLocation", checkpointPath)
      .start()
      .awaitTermination()
  }

  def writeStreamToKafka(df: DataFrame, topic:String) = {
    df
      .writeStream
      .trigger(Trigger.ProcessingTime("20 seconds"))
      .outputMode("complete")
      .format("kafka")
      .option("kafka.bootstrap.servers", "localhost:9092")
      .option("topic", topic)
      .option("checkpointLocation", checkpointPath)
      .start()
      .awaitTermination()
  }
}
