import scala.collection.mutable

object ArithmeticExpressionEvaluation {
  def main(args: Array[String]): Unit = {
    println(evaluate("( ( 2 * ( 12 + 3 ) ) / 3 )"))
  }

  def evaluate(exp: String): Double = {
    val parts = exp.split(' ')
    val vals = new mutable.ArrayStack[Double]()
    val ops = new mutable.ArrayStack[String]()
    parse(parts.toList, vals, ops)
  }

  @scala.annotation.tailrec
  def parse(parts: List[String], vals: mutable.ArrayStack[Double], ops: mutable.ArrayStack[String]): Double = {
    parts match {
      case Nil => vals.pop()
      case head :: tail =>
        head match {
          case "(" =>
          case ")" => vals.push(calc(ops.pop(), vals.pop(), vals.pop))
          case op if List("+", "-", "*", "/") contains op => ops.push(op)
          case value => vals.push(value.toDouble)
        }
        parse(tail, vals, ops)
    }
  }

  // notice the order is right-left
  def calc(op: String, right: Double, left: Double): Double = {
    op match {
      case "+" => left + right
      case "-" => left - right
      case "*" => left * right
      case "/" => left / right
    }
  }
}
