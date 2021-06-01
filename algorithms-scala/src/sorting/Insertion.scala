package sorting

import utils.Swapper

object Insertion extends Sorting with Swapper {
  override def sort[T](arr: Array[T])(implicit ordering: Ordering[T]): Unit = {
    import ordering._

    for {
      i <- 1 until arr.length                       // 1 to arr.len-1
      j <- (i to 1 by -1) if (arr(j) < arr(j - 1))  // i to 1 且错位的
    } swap(arr, j, j - 1)
  }
}
