package sorting

import utils.Swapper

object Bubble extends Sorting with Swapper {
  override def sort[T](arr: Array[T])(implicit ordering: Ordering[T]): Unit = {
    import ordering._
    for {
      i <- 1 until arr.length
      j <- (i until arr.length).reverse if arr(j) < arr(j - 1)
    } if (arr(j) < arr(j - 1)) swap(arr, j, j - 1)
  }
}
