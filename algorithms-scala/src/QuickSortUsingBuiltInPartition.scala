object QuickSortUsingBuiltInPartition {

  def main(args: Array[String]): Unit = {
    val li = List(1, 32, 4, 5, 2, 3, 5, 6, 7, 33)
    println(quickSort(li))
  }

  def quickSort(li: List[Int]): List[Int] = {
    li match {
      case Nil => Nil
      case head :: tail =>
        val (left, right) = tail.partition(_ < head)
        quickSort(left) ++ (head :: quickSort(right))
    }
  }
}
