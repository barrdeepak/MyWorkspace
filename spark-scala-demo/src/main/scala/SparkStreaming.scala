
import Reader.{readCSV, readStocksAsStream}
import UtilityFn.isProfitable
import Writer.{writeStreamToConsole, writeStreamToFile, writeStreamToKafka}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.dsl.expressions.StringToAttributeConversionHelper
import org.apache.spark.sql.functions._


object SparkStreaming {

  val inputPath = "src/main/resources/data/stream"

  val outputPath = "src/main/resources/output"
  val checkpointPath = "src/main/resources/checkpoint"

  lazy implicit val spark = SparkSession.builder()
    .master("local")
    .appName("flight-data-assignment")
    .getOrCreate();

  def main(args: Array[String]) {

    val mappingDim = readCSV("src/main/resources/data/mapping.csv")

    val initDF = readStocksAsStream(inputPath)

    val stockDf = initDF
      .groupBy(col("Name"), year(col("Date")).as("Year"))
      .agg(max("High").as("Max"))

    val resultDf = initDF.select("Name", "Date", "Open", "Close")
    val profitUdf = udf(isProfitable)
    val hydratedResult = resultDf.join(mappingDim, Seq("Name"), "left").withColumn("symbol", col("Name")).withColumn("profit", profitUdf(col("Open"), col("Close")))
    //    writeStreamToFile(hydratedResult, outputPath)
        writeStreamToFile(stockDf, outputPath)
        writeStreamToConsole(stockDf)



    val kafkaDF = stockDf.withColumn("value",
      concat_ws("|", col("Name"), col("Year"), col("Max")))
    writeStreamToKafka(kafkaDF, "stocks_max")
  }

}