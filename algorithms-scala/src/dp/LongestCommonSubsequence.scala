package dp

/**
 * 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
object LongestCommonSubsequence {
  def longestCommonSubsequence(text1: String, text2: String): Int = {
    val n = text1.length
    val m = text2.length
    val c = Array.ofDim[Int](n + 1, m + 1)
    for {
      i <- 0 to n
      j <- 0 to m
    } c(i)(j) = ((i,j) match {
      case (0,_) => 0
      case (_,0) => 0
      case _ =>  math.max(
        math.max(
          c(i-1)(j),
          c(i)(j-1)
        ),
        c(i-1)(j-1) + (if (text1(i-1) == text2(j-1)) 1 else 0)
      )
    })
    c(n)(m)
  }
}
