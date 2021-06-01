package sorting

import utils.Swapper

object Heap extends Sorting with Swapper {
  override def sort[T](arr: Array[T])(implicit ordering: Ordering[T]): Unit = {
    buildHeap(arr)
    for (i <- arr.indices.reverse) {
      swap(arr, 0, i)
      sink(arr, 0, i - 1)
    }
  }

  private def buildHeap[T](arr: Array[T])(implicit ordering: Ordering[T]): Unit = {
    for (i <- arr.length / 2 to 0 by -1) {
      sink(arr, i, arr.length - 1)
    }
  }

  @scala.annotation.tailrec
  def sink[T](arr: Array[T], k: Int, end: Int)(implicit ordering: Ordering[T]): Unit = {
    import ordering._
    if (2 * k + 1 <= end) {
      val j = 2 * k + 1
      val gt = if (j < end && arr(j + 1) > arr(j)) j + 1 else j // 注意这里判断 2k+2 <= len
      if (arr(gt) > arr(k)) {
        swap(arr, gt, k)
        sink(arr, gt, end)
      }
    }
  }
}
