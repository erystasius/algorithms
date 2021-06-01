object InsertionSortFunctional {
  def main(args: Array[String]): Unit = {
    val li = List(1, 32, 4, 5, 2, 3, 5, 6, 7, 33)
    val sorted = insertionSort(li)
    println(sorted)
  }

  def insertionSort(li: List[Int]): List[Int] = shift(li, Nil)

  @scala.annotation.tailrec
  def shift(li: List[Int], sorted: List[Int]): List[Int] = li match {
    case Nil => sorted
    case head :: tail => shift(tail, insert(head, sorted))
  }

  def insert(target: Int, sorted: List[Int]): List[Int] = sorted match {
    case head :: tail if head < target => head :: insert(target, tail)
    case _ => target :: sorted
  }
}

