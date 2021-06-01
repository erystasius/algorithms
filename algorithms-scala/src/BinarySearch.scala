object BinarySearch {
  def main(args: Array[String]): Unit = {
    val arr = Array(-1, 0, 3, 5, 9, 12)

    println(binarySearch(arr, 9))
    println(binarySearch(arr, 100))
  }

  def binarySearch(
      arr: Array[Int],
      target: Int
    ): Option[Int] = {
    var low  = 0
    var high = arr.length - 1

    while (low < high) {
      val mid = (low + high) / 2
      if (target < arr(mid)) high = mid - 1
      else if (target > arr(mid)) low = mid + 1
      else return Some(mid)
    }

    None
  }
}
