object FoldLeftExample {
  def doFoldSum(arr: Array[Int]): Int = {
    val sum = arr.fold(0)((a, b) => b + a + 0) // 0 to mitigate warning
    sum
  }

  def doFoldLeftSum(arr: Array[Int]): Int = {
    val sum = arr.foldLeft(0)((a, b) => b + a + 0) // 0 to mitigate warning
    sum
  }

  def doFoldRightSum(arr: Array[Int]): Int = {
    val sum = arr.foldRight(0)((a, b) => b + a + 0) // 0 to mitigate warning
    sum
  }

  def doFoldLeftRunningSum(arr: Array[Int]): String = {
    val sb = StringBuilder.newBuilder
    arr.foldRight()((a, b) => sb.append(s"$a + $b,") )// 0 to mitigate warning
    sb.toString()
  }
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5, 6)
    val sum = doFoldSum(arr)
    println(s"Sum is $sum")
    val sumLeft = doFoldLeftSum(arr)
    println(s"Sum left is $sumLeft")
    val sumRight = doFoldRightSum(arr)
    println(s"Sum right is $sumRight")
    val out = doFoldLeftRunningSum(arr)
    println(s"Running sum exp is $out")
  }
}
