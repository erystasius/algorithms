import scala.collection.mutable

/**
 * 用例
 * ""
 * "[[[[["
 * "]]]]]"
 *
 *
 */
object ValidParentheses {
  def isValid(s: String): Boolean = {
    val stack = mutable.Stack[Char]()
    for (i <- s.indices) {
      s(i) match {
        case '(' | '{' | '[' => stack.push(s(i))
        case right => if (stack.isEmpty || !pair(stack.pop(), right)) return false // 注意 pop 的危险性，还有写条件的时候用 ||
      }
    }
    stack.isEmpty // 注意
  }

  def pair(left: Char, right: Char): Boolean = {
    val m = Map('{' -> '}', '(' -> ')', '[' -> ']')
    m(left) == right
  }

  def main(args: Array[String]): Unit = {
    println(isValid("[")   )
  }
}
