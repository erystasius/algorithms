package st

class RedBlackTree[K, V](implicit ordering: Ordering[K]) {
  import ordering._

  final val Red = true
  final val Black = false

  var root: Node = _

  def size: Int = size(root)

  private def size(node: Node): Int = if (node == null) 0 else node.size

  def get(k: K): Option[V] = {
    get(root, k)
  }

  private def get(node: Node, k: K): Option[V] = {
    if (node == null) None
    else if (k < node.k) get(node.left, k)
    else if (k > node.k) get(node.right, k)
    else Some(node.v)
  }

  def put(k: K, v: V): Unit = {
    root = put(root, k, v)
    root.color = Black // 问题
  }

  private def put(node: Node, k: K, v: V): Node = {
    if (node == null) Node(k, v, null, null, Red, 1)
    else {
      var n = node

      if      (k < n.k)   n.left = put(n.left, k, v)        // mistake: 没有赋值, mistake2: put 后 size + 1（内层可能成功找到，不一定会新增节点）
      else if (k > n.k)   n.right = put(n.right, k, v) // mistake: 没有赋值, mistake2: put 后 size + 1（内层可能成功找到，不一定会新增节点）
      else                n.v = v

      n.size = 1 + size(n.left) + size(n.right) // mistake: 在 put 后改变 size

      if (isBlack(n.left) && isRed(n.right)) n = rotateLeft(n)
      if (isRed(n.left) && isRed(n.left.left)) n = rotateRight(n)
      if (isRed(n.left) && isRed(n.right)) n = flipColor(n)

      n
    }
  }

  private def isRed(node: Node): Boolean =
    if (node == null) false
    else node.color == Red

  private def isBlack(node: Node): Boolean = !isRed(nod

  private def rotateLeft(node: Node): Node = {
    val x = node.right
    node.right = x.left
    x.left = node

    x.color = node.color // mistake: lack(statement)
    node.color = Red // mistate: lack(statement)

    x.size = node.size
    node.size = 1 + size(node.left) + size(node.right)

    x
  }

  private def rotateRight(node: Node): Node = {
    val x = node.left
    node.left = x.right
    x.right = node

    x.color = node.color  // mistake: lack(statement)
    node.color = Red  // mistate: lack(statement)

    x.size = node.size
    node.size = 1 + size(node.left) + size(node.right)

    x
  }

  private def flipColor(node: Node): Node = {
    node.left.color = Red
    node.right.color = Black // mistake: wrong(red)
    node.color = Black // mistabe: wrong(red)

    node
  }

  case class Node(var k: K, var v: V, var left: Node, var right: Node, var color: Boolean, var size: Int)
}
