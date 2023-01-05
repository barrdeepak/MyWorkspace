import org.apache.spark.sql.Column
import org.apache.spark.sql.functions._

object UtilityFn {

  // UDF
  def isProfitable = (low: Double, high: Double) => {
    low < high
  }

  def getFileName: Column = {
    val file_name = reverse(split(input_file_name(), "/")).getItem(0)
    split(file_name, "_").getItem(0)
  }
}
