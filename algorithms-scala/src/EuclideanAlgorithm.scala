object EuclideanAlgorithm {
  def main(args: Array[String]): Unit = {
    print(gcd(252, 105))
  }

  @scala.annotation.tailrec
  def gcd(p: Int, q: Int): Int =
    if (q == 0)
      p
    else
      gcd(q, p % q)
}
