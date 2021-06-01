package sorting

trait Sorting {
  def sort[T](arr: Array[T])(implicit ordering: Ordering[T]): Unit
}
