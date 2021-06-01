package sorting
import scala.reflect.ClassTag

object MergeTopDown extends Sorting {
  def sort[T](arr: Array[T])(implicit ordering: Ordering[T]): Unit = {
    implicit val classTag: ClassTag[T] = ClassTag(arr(0).getClass)
    implicit val aux: Array[T] = new Array[T](arr.length)

    sort(arr, 0, arr.length - 1)
  }

  def sort[T](arr: Array[T], low: Int, high: Int)
    (implicit aux: Array[T],ordering: Ordering[T]): Unit = {
    if (low >= high) return    // 注意此处不要使用 nums.length
    val mid = (low + high) / 2 // 注意此处 会落在 floor((low + high) / 2)
    sort(arr, low, mid)
    sort(arr, mid + 1, high)
    merge(arr, low, mid, high)
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
      else if (aux(i) < aux(j)) { arr(k) = aux(i); i = i + 1 } // 注意此处使用 aux, 而不是 num
      else                      { arr(k) = aux(j); j = j + 1 }
    }
  }
}
