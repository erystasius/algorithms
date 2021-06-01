package dp

/**
 * 最大子序列和
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
object MaximumSubarray {
  def maxSubArray(nums: Array[Int]): Int = {
    val n = nums.length
    val m = new Array[Int](n) // m(i) 的定义是：以元素 i 结尾的最大子数组的和
    m(0) = nums(0)
    for (i <- 1 until n) {
      m(i) = math.max(m(i-1) + nums(i), nums(i))
    }
    m.max     // 最后需要查找整个 m，而不是取最后的位置
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    println(maxSubArray(nums))
  }
}
