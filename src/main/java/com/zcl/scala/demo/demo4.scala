trait Philosophical {
  def philosophize(): Unit = {
    println("I consume memory ,therefore i am!")
  }
}

class Animal

trait HasLegs

class Frog extends Animal with Philosophical with HasLegs {
  override def toString: String = "green"

  override def philosophize(): Unit = {
    println("It ain't esay beging " + toString + "!")
  }
}

val frog = new Frog
frog.philosophize()

val phil: Philosophical = frog
phil.philosophize()

trait CharSequence {
  def chatAt(index: Int): Char

  def length: Int

  def subSequence(start: Int, end: Int): CharSequence

  def toString(): String
}

