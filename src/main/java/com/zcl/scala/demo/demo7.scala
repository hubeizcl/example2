import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int

  def put(x: Int)
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(2 * x)
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(x + 1)
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) = if (x >= 0) super.put(x)
}

class BasicIntQueue extends IntQueue {

  private val buf = new ArrayBuffer[Int]()

  override def get(): Int = buf.remove(0)

  override def put(x: Int): Unit = buf += x
}

class MyQueue extends BasicIntQueue with Doubling with Incrementing with Filtering

val queue = new MyQueue
queue.put(10)
queue.put(-2)
queue.put(0)
queue.get()
