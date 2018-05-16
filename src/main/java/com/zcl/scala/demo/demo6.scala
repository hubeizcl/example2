
class Rational(n: Int, d: Int) extends Ordered[Rational] {
  val number = n
  val denmo = d

  //  def <(that: Rational) = this.number * that.denmo > that.number * this.denmo
  //
  //  def >(that: Rational) = that < this
  //
  //  def <=(that: Rational) = (this < that) || (this == that)
  //
  //  def >=(that: Rational) = (this > that) || (this == that)
  override def compare(that: Rational): Int = (this.number * that.denmo) - (this.denmo * that.number)
}

val half = new Rational(1, 2)
val third = new Rational(1, 3)

half<third