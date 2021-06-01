package dp

/**
 * 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
object MinimumPathSum {
  def minPathSum(grid: Array[Array[Int]]): Int = {
    val cur = grid(0)
    // 如果初始化第一个元素，就要遍历全部二维数组，处理时考虑 i-1, j-1 越界
    // 如果初始化第一排，就从第二排开始遍历，初始化第一排想清楚，处理时考虑 j-1 越界，
    for {
      i <- grid.indices
      j <- grid(i).indices
    } cur(j) = grid(i)(j) + ((i, j) match {
      case (0, 0) => 0
      case (_, 0) => cur(j)
      case (0, _) => cur(j - 1)
      case (_, _) => math.min(cur(j), cur(j - 1))
    })
    cur(cur.length - 1)
  }

  def main(args: Array[String]): Unit = {
    val grid: Array[Array[Int]] = Array(
      Array(1, 3, 1),
      Array(1, 5, 1),
      Array(4, 2, 1)
    )
    println(minPathSum(grid))
  }
}
