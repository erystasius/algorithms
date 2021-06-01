package st

import scala.io.Source

object TestClient {
  def main(args: Array[String]): Unit = {
//    val st = new LinkedListST[String, Int]
//    val st = new OrderedArrayST[String, Int](1000)
//    val st = new BinarySearchTree[String, Int]
    val st = new RedBlackTree[String, Int]()
    val source = Source.fromFile("algorithms-scala/in/tinyTale.txt")
    val iter   = source.getLines().map(_.split(" ")).flatMap(as => as.toList)
//    val li     = iter.toList
//    val se     = li.toSet
//    println(li, li.size, se, se.size)
    while (iter.hasNext) {
      val word = iter.next()
      st.get(word) match {
        case Some(count) => st.put(word, count + 1)
        case None        => st.put(word, 1)
      }
    }
    println(st.size)
    println(st.get("it"))
    println(st.get("the"))
    println(st.get("epoch"))
    println(st.get("wisdom"))
  }
}
