abstract class Element {
  //  def content: Array[String]

  def demo(): Unit = {
    println("Element's implementation invoked")
  }

  //  def height: Int = content.length
  //
  //  def width: Int = if (height == 0) 0 else content(0).length
}

class ArrayElement(conts: Array[String]) extends zcl.Element {
  val content: Array[String] = conts

}

class ArrayElements(val contents: Array[String]) extends zcl.Element {
  val content: Array[String] = x123
}

class Cat {
  val dangerous = false
}

class Tiger(override val dangerous: Boolean, private var age: Int) extends Cat {

}

class Tigers(param1: Boolean, param2: Int) extends Cat {
  override val dangerous: Boolean = param1
  private var age = param2
}

class LineElement(s: String) extends ArrayElement(Array(s)) {
  //  override def height: Int = s.length
  //
  //  override def width: Int = 1
}

class UniformElement extends Element {
  //  private val line = ch.toString * width
  //
  //  def content: Array[String] = Array.make(height, line)
}

val e1: zcl.Element = new ArrayElement(Array("hello", "world", "!"))
val ae: ArrayElement = new LineElement("hello")
val e2: zcl.Element = ae
//val e3: Element = new UniformElement('x', 2, 3)