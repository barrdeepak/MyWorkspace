object TupleExample {

  def main(args: Array[String]): Unit = {
    val person = ("Abc", 25, "Singapore")
    println(person._1)
    println(person._2)
    println(person._3)
    person.productIterator.foreach(println)
    println(person.toString())
  }
}
