package st

class LinkedListST[K, V] extends ST[K, V] {
  var first: Node = _

  override def size: Int = throw new Exception("no")

  override def isEmpty: Boolean = throw new Exception("no")

  def put(
      k: K,
      v: V
    ): Unit = {
    @scala.annotation.tailrec
    def put(
        k: K,
        v: V,
        node: Node
      ): Unit =
      if (node == null) first = new Node(k, v, first) // 未命中
      else if (node.k == k) node.v = v                // 命中
      else put(k, v, node.next)

    put(k, v, first)
  }

  def get(k: K): Option[V] = {
    @scala.annotation.tailrec
    def get(
        k: K,
        node: Node
      ): Option[V] =
      if (node == null) None             // 未命中
      else if (node.k == k) Some(node.v) // 命中
      else get(k, node.next)

    get(k, first)
  }

  def loopVerPut(
      k: K,
      v: V
    ): Unit = {
    var node = first
    while (node != null) {
      if (node.k == k) {
        node.v = v; return
      } // 命中
      node = node.next
    }
    first = new Node(k, v, first) // 未命中，建立新节点
  }

  def loopVerGet(k: K): Option[V] = {
    var node = first
    while (node != null) {
      if (node.k == k) return Some(node.v) // 命中
      node = node.next
    }
    None // 未命中
  }

  class Node(
      var k: K,
      var v: V,
      var next: Node)
}
