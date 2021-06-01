package st

class BinarySearchTree[K, V](implicit ordering: Ordering[K]) extends ST[K, V] {
  import ordering._
  var root: Node = _

  def isEmpty: Boolean = root == null

  def size: Int = size(root)

  def size(node: Node): Int = if (node == null) 0 else node.size

  def put(
      k: K,
      v: V
    ): Unit =
    root = put(root, k, v)

  def get(k: K): Option[V] =
    get(root, k)

  private def put(
      node: Node,
      k: K,
      v: V
    ): Node = // this function will return a Node for the caller to replace the old one
    if (node == null) Node(k, v, null, null, 1) // miss, return a new node
    else {
      // the whole if is for updating a node
      if (k < node.k) node.left = put(node.left, k, v)        // notice you update node.left
      else if (k > node.k) node.right = put(node.right, k, v) // notice you update node.right
      else node.v = v                                         // hit

      // after updating the node, refresh the size
      node.size = size(node.left) + size(node.right) + 1 // the size is not always increasing, it will not increase if search hit

      // then return the node
      node
    }

  @scala.annotation.tailrec
  private def get(
      node: Node,
      k: K
    ): Option[V] =
    if (node == null) None
    else if (k < node.k) get(node.left, k)
    else if (k > node.k) get(node.right, k)
    else Some(node.v)

  // remember vars
  case class Node(
      var k: K,
      var v: V,
      var left: Node,
      var right: Node,
      var size: Int)
}
