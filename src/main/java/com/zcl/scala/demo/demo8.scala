package bobsdelights

abstract class Fruit(val name: String, val color: String)

object Fruit {

  object Apple extends Fruit("Apple", "red")

  object Orange extends Fruit("Orange", "Orange")

  object Pear extends Fruit("pear", "yellowish")

  val menu = List(Apple, Orange, Pear)

}

object showFruit {

  import Fruit._

  def showFruit(fruit: Fruit): Unit = {
    println(fruit.name + "" + fruit.color)
  }
}
