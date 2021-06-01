package sorting

import scala.io.Source

object TestClient {
  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("algorithms-scala/in/1Knums.txt")
    val arr = file
      .getLines()
      .map(_.trim)
      .map(_.toInt)
      .toArray

//    Selection.sort(arr)
//    Bubble.sort(arr)
//    Insertion.sort(arr)
//    Shell.sort(arr)
//    MergeTopDown.sort(arr)
//    MergeBottomUp.sort(arr)
//    Quick.sort(arr)
    Heap.sort(arr)

    show(arr)
    assert(isSorted(arr))
  }

  private def isSorted[T](arr: Array[T])(implicit ordering: Ordering[T]) = {
    import ordering._
    1 until arr.length forall (i => arr(i) >= arr(i - 1))
  }

  private def show[T](arr: Array[T]): Unit = println(arr.mkString(","))

}
