import UtilityFn.getFileName
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.types.{DoubleType, StringType, StructField, StructType}

object Reader {


  def readStocksAsStream(path:String)(implicit spark: SparkSession): DataFrame = {

    val schema = StructType(List(
      StructField("Date", StringType, true),
      StructField("Open", DoubleType, true),
      StructField("High", DoubleType, true),
      StructField("Low", DoubleType, true),
      StructField("Close", DoubleType, true),
      StructField("Volume", DoubleType, true),
      StructField("Name", StringType, true)
    ))

    val df = spark
      .readStream
      .format("csv")
      .option("maxFilesPerTrigger", 1) // This will read maximum of 2 files per mini batch. However, it can read less than 2 files.
      .option("header", false)
      .option("path", path)
      .schema(schema)
      .load()
      .withColumn("Name", getFileName)
    df
  }

  def readCSV(path:String)(implicit spark: SparkSession): DataFrame = {
    spark.read.format("csv").option("inferSchema", true).option("header", true).load(path)
  }
}
