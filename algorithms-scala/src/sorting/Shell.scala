package sorting

import utils.Swapper

object Shell extends Sorting with Swapper {
  override def sort[T](arr: Array[T])(implicit ordering: Ordering[T]): Unit = {
    import ordering._
    var h = 1
    while (h < arr.length / 3) h = 3 * h + 1 // 保证选取的 h 递减到 1
    while (h >= 1) {
      for {
        i <- h until arr.length
        j <- i to h by -h if arr(j) < arr(j - h)
      } swap(arr, j, j - h)
      h = h / 3
    }
  }
}
