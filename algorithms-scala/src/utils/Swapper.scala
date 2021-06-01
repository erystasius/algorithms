package utils

trait Swapper {
  def swap[T](arr: Array[T], i: Int, j: Int): Unit = {
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }
}
