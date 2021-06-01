import java.time.{Duration, Instant}

import scala.io.Source

object UnionFindUsingQuickFind {
  class UF(n: Int) {
    private var c = 0
    private val ids = (0 until n).toArray
    def count(): Int = c
    def connected(p: Int, q: Int): Boolean = find(p) == find(q)
    def union(p: Int, q: Int): Unit = {
      if (find(p) == find(q)) None
      else {
        for (i <- 0 until n if find(i) == find(q)) {
          ids(i) = find(p)
        }
        c = c - 1
      }
    }
    def find(p: Int): Int = ids(p)
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
    println(uf.connected(5,7))
    val connected = Instant.now()
    val unionDuration = Duration.between(start, union)
    val connectedDuration = Duration.between(union, connected)
  }
}
