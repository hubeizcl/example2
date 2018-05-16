sealed abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operation: String, arg: Expr) extends Expr

case class BinOp(operation: String, left: Expr, right: Expr) extends Expr

val e = Number(Math.E)

def simplifyTop(expr: Expr): Any = expr match {
  case UnOp("-", UnOp("-", e)) => simplifyTop(e) //双重负号
  case BinOp("+", e, Number(0)) => e //加0
  case BinOp("*", e, Number(1)) => e //乘1
  case BinOp(_, _, _) => println(expr + "is a binary operation")
  case List(0, _, _) => println("Found it")
  case List(0, _*) => println("found it")
  case (a, b, c) => println("mathched " + a + b + c)
  case BinOp("+", x, y) if x == y => BinOp("*", x, (Number(2)))
  case Number(_) => "a number"
  case _ => throw new RuntimeException
}
UnOp("-", UnOp("-", e))

def describe(x: Any): Any = x match {
  case 5 => "five"
  case true => "truth"
  case "hello" => "hi!"
  case Nil => "the empty list"
  case s: String => s.length
  case m: Map[_, _] => m.size
  case m: Map[Int, Int] => true
  case _ => "something else"

}

import Math.{PI, E}

E match {
  case PI => "strange math? Pi=" + PI
  case _ => "OK"
}
