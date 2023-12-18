object ImplicitExample {
  def printValue()(implicit a: Double, b: Int): Unit = {
    println(s"Value is $a")
    println(s"Value is $b")
  }

  def main(args: Array[String]): Unit = {
    implicit val a: Int = 100
    implicit val b: Double = 101.9
    printValue()
  }
}
