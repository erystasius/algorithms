import java.time.{Duration, Instant}

import scala.io.Source

object UnionFindUsingQuickUnion {
  class UF(n: Int) {
    private var c = 0
    private val ids = (0 until n).toArray
    def count(): Int = c
    def connected(p: Int, q: Int): Boolean = find(p) == find(q)
    def union(p: Int, q: Int): Unit = {
      val pRoot = find(p)
      val qRoot = find(q)
      if (pRoot == qRoot) None
      else {
        ids(p) = ids(q)
        c = c - 1
      }
    }
    def find(p: Int): Int = {
      if (ids(p) == p) p
      else find(ids(p))
    }
  }

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("algorithms-scala/in/tinyUF.txt")
    val lines = source.getLines().toList
    val uf = new UF(lines.head.toInt)
    val start = Instant.now()
    lines
      .tail
      .map(_.split(' '))
      .map(_.map(_.toInt))
      .foreach(arr => uf.union(arr(0), arr(1)))
    val union = Instant.now()
    println(uf.connected(3,8))
    val connected = Instant.now()
  }
}
