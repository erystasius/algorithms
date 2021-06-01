package st

trait ST[K, V] {
  def get(k: K): Option[V]
  def put(
      k: K,
      v: V
    ): Unit
  def size: Int
  def isEmpty: Boolean
  def contains(k: K): Boolean = get(k).isDefined
}
