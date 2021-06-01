object QuickSortFunctional {

  def main(args: Array[String]): Unit = {
    val li = List(1, 32, 4, 5, 2, 3, 5, 6, 7, 33)
    println(quickSort(li))
  }

  def quickSort(li: List[Int]): List[Int] = {
    li match {
      case Nil => Nil
      case head :: tail =>
        quickSort(tail.filter(_ <= head)) ++
          List(head) ++
          quickSort(tail.filter(_ > head))
    }
  }
}
