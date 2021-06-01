package dp

/**
 * 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 */
object UniquePaths {
  def uniquePaths(m: Int, n: Int): Int = {
    val p = Array.ofDim[Int](m, n)
    for {
      i <- 0 until m
      j <- 0 until n
    } p(i)(j) = (i,j) match {
      case (0,0) => 1
      case (0,_) => 1
      case (_,0) => 1
      case (_,_) => p(i-1)(j) + p(i)(j-1)
    }
    p(m - 1)(n - 1)
  }

  def uniquePathsOptimized(m: Int, n: Int): Int = {
    val p = new Array[Int](n)
    for (i <- 0 until n) p(i) = 1
    for {
      _ <- 1 until m
      j <- 0 until n
    } p(j) = if (j == 0) p(j) else p(j - 1) + p(j)
    p(n - 1)
  }

  def main(args: Array[String]): Unit = {
    val res = uniquePathsOptimized(7, 3)
    println(res)
  }
}
