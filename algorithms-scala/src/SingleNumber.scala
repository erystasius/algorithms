object SingleNumber {
  def singleNumber(nums: Array[Int]): Int = {
    var i = 0
    var flag = true
    while (i < nums.length && flag) {
      find(nums, i + 1, nums.length - 1, nums(i)) match {
        case Some(value) =>
          println(s"swapping ${i+1}, $value")
          swap(nums, i + 1, value)
          i = i + 2
        case None => flag = false
      }
    }
    println(i)
    nums(i)
  }

  private def notSingle(nums: Array[Int], i: Int) = {
    find(nums, i + 1, nums.length - 1, nums(i)).isDefined
  }

  @scala.annotation.tailrec
  def find(nums: Array[Int], low: Int, high: Int, target: Int): Option[Int] = {
    if (low > high) None
    else {
      val mid = (low + high) / 2
      if (target < nums(mid)) find(nums, low, mid - 1, target)
      else if (target > nums(mid)) find(nums, mid + 1, high, target)
      else Some(mid)
    }
  }

  def swap(ints: Array[Int], i: Int, i1: Int) = {
    val temp = ints(i)
    ints(i) = ints(i1)
    ints(i1) = temp
  }

  def main(args: Array[String]): Unit = {
    List(1).toSet
    var arr = Array(17, 12, 5, -6, 12, 4, 17, -5, 2, -3, 2, 4, 5, 16, -3, -4, 15, 15, -4, -5, -6)
    println(singleNumber(arr))
  }
}
