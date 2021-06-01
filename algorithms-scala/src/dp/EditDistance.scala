package dp

/**
 * 编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 */
object EditDistance {
  def minDistance(word1: String, word2: String): Int = {
    val n = word1.length
    val m = word2.length
    val edit = Array.ofDim[Int](n + 1, m + 1) // 空字符串的处理被涵盖进去了
    for {
      i <- 0 to n
      j <- 0 to m
    } edit(i)(j) = (i, j) match {
      case (0, 0) => 0
      case (0, _) => j
      case (_, 0) => i
      case _ => math.min(
        math.min(
          edit(i - 1)(j) + 1,
          edit(i)(j - 1) + 1
        ),
        edit(i - 1)(j - 1) + (if (word1(i-1) == word2(j-1)) 0 else 1)
      )
    }
    edit(n)(m)
  }

  def main(args: Array[String]): Unit = {
    val res = minDistance("", "123")
    println(res)
  }
}
