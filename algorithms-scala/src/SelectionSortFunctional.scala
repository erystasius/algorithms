object SelectionSortFunctional {
  def main(args: Array[String]): Unit = {
    val li = List(1, 32, 4, 5, 2, 3, 5, 6, 7, 33)
    val sorted = selectionSort(li)
    println(sorted)
  }

  def selectionSort(li: List[Int]): List[Int] = {
    li match {
      case Nil => Nil
      case _ => li.filter(_ == li.min) ::: selectionSort(li.filterNot(_ == li.min))
    }
  }
}
