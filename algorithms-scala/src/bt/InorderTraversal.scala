package bt

import scala.collection.mutable

object InorderTraversal {
  def inorderTraversal(root: TreeNode): List[Int] = {
    val stack = new mutable.ArrayStack[TreeNode]()
    val output = mutable.ListBuffer.empty[Int]

    var cur = root
    while (cur != null) {
      stack.push(cur)
      if (cur.left != null) cur = cur.left
      else if (stack.nonEmpty) {
        cur = stack.pop()
        output += cur.value
      } else {
        cur = null
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
