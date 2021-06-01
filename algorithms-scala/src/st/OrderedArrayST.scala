package st

class OrderedArrayST[K, V](val capacity: Int)(implicit ordering: Ordering[K]) extends ST[K, V] {
  import ordering._

  var items = new Array[Item](capacity)
  var n     = 0

  override def size: Int = n

  override def isEmpty: Boolean = n == 0

  def get(k: K): Option[V] = {
    val r = rank(k)
    if (r < n && items(r).k == k) Some(items(r).v)
    else None
  }

  def put(
      k: K,
      v: V
    ): Unit = {
    val r = rank(k)
    // 注意 rank < n
    if (r < n && items(r).k == k) items(r).v = v
    else {
      for (i <- n until r by -1) // 此处的 n 是 length，item(n) 处是空
        items(i) = items(i - 1)
      items(r) = Item(k, v)
      n = n + 1
    }
  }

  def rank(k: K): Int = rank(0, n - 1, k) // n - 1 即是 keys.length - 1，这个 - 1 很容易漏

  @scala.annotation.tailrec
  final def rank(
      low: Int,
      high: Int,
      target: K
    ): Int =
    if (low > high) low
    else {
      val mid     = (low + high) / 2
      val midItem = items(mid)
      if (target < midItem.k) rank(low, mid - 1, target)
      else if (target > midItem.k) rank(mid + 1, high, target)
      else mid
    }

  case class Item(
      k: K,
      var v: V)
}
