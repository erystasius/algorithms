package sorting

import scala.reflect.ClassTag

object MergeBottomUp extends Sorting {
  import math._
  def sort[T](arr: Array[T])(implicit ordering: Ordering[T]): Unit = {
    implicit val classTag: ClassTag[T] = ClassTag(arr(0).getClass)
    implicit val aux: Array[T] = new Array[T](arr.length)

    var step = 1
    while (step < arr.length) {
      for (j <- arr.indices by 2 * step) {
        val mid   = min(j + step - 1,     arr.length - 1)
        val high  = min(j + 2 * step - 1, arr.length - 1)
        merge(arr, j, mid, high)
      }
      step = step * 2
    }
  }

  def merge[T](arr: Array[T], low: Int, mid: Int, high: Int)
    (implicit aux: Array[T], ordering: Ordering[T]): Unit = {
    import ordering._
    var i = low
    var j = mid + 1
    for (k <- low to high) aux(k) = arr(k)
    for (k <- low to high) {
      if (i > mid)              { arr(k) = aux(j); j = j + 1 }
      else if (j > high)        { arr(k) = aux(i); i = i + 1 }
      else if (aux(i) < aux(j)) { arr(k) = aux(i); i = i + 1 }
      else                      { arr(k) = aux(j); j = j + 1 }
    }
  }
}
