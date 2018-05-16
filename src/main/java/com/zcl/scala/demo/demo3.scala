abstract class demo3 {
  def content: Array[String]

  def height: Int = content.length

  def width: Int = if (height == 0) 0 else content(0).length


  def above(that: demo3): demo3 = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this.content ++ that.content)
  }


  def beside(that: demo3): demo3 = {
    val this1 = this highten that.height
    val that1 = that highten this.height
    elem(for ((line1, line2) <- this.content zip that.content) yield line1 + line2)
  }

  def widen(w: Int): demo3 = {
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      var right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }
  }

  def highten(h: Int): demo3 = {
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      var bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }
  }

  override def toString: String = content mkString "\n"

}
