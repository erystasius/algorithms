package sorting

import utils.Swapper

object Quick extends Sorting with Swapper {
  override def sort[T](arr: Array[T])(implicit ordering: Ordering[T]): Unit =
    sort(arr, 0, arr.length - 1)

  def sort[T](arr: Array[T], low: Int, high: Int)(implicit ordering: Ordering[T]): Unit = {
    if (low < high) {
      val p = partition(arr, low, high)
      sort(arr, low, p - 1)
      sort(arr, p + 1, high)
    }
  }

  def partition[T](arr: Array[T], lo: Int, hi: Int)(implicit ordering: Ordering[T]): Int = {
    import ordering._
    val pivot = arr(lo)
    var i = lo + 1
    var j = hi
    do {
      while (arr(i) <= pivot && i < hi) i = i + 1 // first arr(i) > pival or the rightmost
      while (arr(j) >  pivot && j >= i) j = j - 1 // first arr(j) <= pival, or i-1
      if (i < j) swap(arr, i, j)
    } while (i < j) // when it stops, all element right to j is greater than pival
    swap(arr, lo, j) // j is the rightmost of left subarray where all elements are less or equal to pival
    j
  }
}
