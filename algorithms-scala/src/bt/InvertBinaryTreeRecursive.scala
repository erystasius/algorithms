package bt

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
object InvertBinaryTreeRecursive {
  def invertTree(root: TreeNode): TreeNode =
    if (root == null) null
    else {
      val temp = root.left
      root.left = root.right
      root.right = temp
      root.left = invertTree(root.left)
      root.right = invertTree(root.right)
      root
    }

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = _
    var right: TreeNode = _
  }
}

