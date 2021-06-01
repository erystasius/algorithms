package bt

import scala.collection.mutable.ListBuffer

object PreorderTraversal {
  def preorderTraversal(root: TreeNode): List[Int] = {
    val output = ListBuffer.empty[Int]
    var stack = List(root)

    while (stack.nonEmpty) {
      val cur = stack.head; stack = stack.tail // pop
      if (cur != null) {
        output += cur.value
        stack = cur.right :: stack
        stack = cur.left :: stack
      }
    }

    output.toList
  }

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = _
    var right: TreeNode = _
  }
}
