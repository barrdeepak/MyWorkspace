object YieldExample {

  def useYeildToComputeSquare(input: Array[Int]): Array[Int] = {
    val result = for(i <- input) yield Math.pow(i,2).toInt
      result
  }

  def main(args:Array[String]):Unit = {
    val input = Array(1,2,3,4,5,6)
    val square = useYeildToComputeSquare(input)
    println("The squares are ")
    square.foreach(x => println(x))
    //same as above
    square.foreach(println(_))
    //same as above
    square.foreach(println)
    //same as above
    square.iterator.foreach(println)
  }
}
