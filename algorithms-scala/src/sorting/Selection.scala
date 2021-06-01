package sorting

import utils.Swapper

object Selection extends Sorting with Swapper {
  override def sort[T](arr: Array[T])(implicit ordering: Ordering[T]): Unit = {
    import ordering._

    for (i <- arr.indices) { // 0 to arr.len-1
      var min = i
      for (j <- i + 1 until arr.length) // i+1 to arr.len-1
        if (arr(j) < arr(min))
          min = j
      if (min != i) swap(arr, i, min)
    }
  }
}
