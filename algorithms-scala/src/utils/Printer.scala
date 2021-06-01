package utils

object Printer {
  def print[T](array: Array[Array[T]]): Unit = array.map("["+_.mkString(",")+"]").foreach(println)
  def print[T](array: Array[T]): Unit = println(s"[${array.mkString(",")}]")
}
