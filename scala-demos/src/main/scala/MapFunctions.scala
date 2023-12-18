object MapFunctions {

  def main(arr:Array[String]):Unit = {
    val str = "Scala for Google"
    println(str.map(_.toUpper))
    val s = str.flatMap(c => c.toUpper.toString)
    println(s)
  }
}
