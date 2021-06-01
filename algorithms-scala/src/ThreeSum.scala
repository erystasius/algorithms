import java.time.{Duration, Instant}

import scala.io.Source

object ThreeSum {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("algorithms-scala/in/8Kints.txt")
    val nums = source.getLines().toArray.map(_.trim).map(_.toInt)
    val start = Instant.now()
    println(threeSum(nums))
    val end = Instant.now()
    val duration = Duration.between(start, end)
    println(duration)
    source.close()
  }

  def threeSum(arr: Array[Int]): Int = threeSum(arr.toList)

  def threeSum(li: List[Int]): Int = li match {
    case Nil => 0
    case ::(head, tail) => twoSum(tail, head) + threeSum(tail)
  }

  def twoSum(nums: List[Int], first: Int): Int = nums match {
    case Nil => 0
    case second :: tail => tail.count(_ + second + first == 0) + twoSum(tail, first)
  }
}
