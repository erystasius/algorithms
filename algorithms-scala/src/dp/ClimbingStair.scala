package dp

/**
 * 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
object ClimbingStair {
  def climbeStairs(n: Int): Int = {
    n match {
      case 1 => 1 // 注意：单独判断越界可能
      case _ =>
        val ways = new Array[Int](n + 1)
        for (i <- 0 to 2) ways(i) = i        // 如果 n = 1，此处会越界
        for (i <- 3 to n) ways(i) = ways(i - 1) + ways(i - 2)
        ways(n)
    }
  }
}
