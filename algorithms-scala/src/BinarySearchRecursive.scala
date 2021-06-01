object BinarySearchRecursive {
  def main(args: Array[String]): Unit = {
    val arr = Array(-1, 0, 3, 5, 9, 12)

    println(binarySearch(arr, 9))
    println(binarySearch(arr, 100))
  }

  def binarySearch(
      arr: Array[Int],
      target: Int
    ): Option[Int] =
    binarySearch(arr, 0, arr.length - 1, target)

  @scala.annotation.tailrec
  def binarySearch(
      arr: Array[Int],
      low: Int,
      high: Int,
      target: Int
    ): Option[Int] =
    if (low > high) None
    else {
      val mid = (low + high) / 2
      arr(mid) match {
        case x if target == x => Some(mid)
        case x if target > x  => binarySearch(arr, mid + 1, high, target)
        case x if target < x  => binarySearch(arr, low, mid - 1, target)
      }
    }
}
