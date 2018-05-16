class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)

  val number: Int = n / g

  val denmo: Int = d / g

  override def toString: String = "Created " + number + "/" + denmo

  def this(n: Int) = this(n, 1)

  def +(that: Rational): Rational =
    new Rational(number * that.denmo + that.number * denmo, denmo * that.denmo)

  def -(that: Rational): Rational =
    new Rational(this.number * that.denmo - that.number * this.denmo, this.denmo * that.denmo)

  def -(i: Int): Rational =
    new Rational(this.number - i * this.denmo, this.denmo)

  //  def *(that: Rational): Rational =
  //    new Rational(this.number * that.number, this.denmo * that * denmo)

  //  def *(i: Int): Rational =
  //    new Rational(this.number * i, this.denmo)

  def /(that: Rational): Rational =
    new Rational(this.number * that.denmo, this.denmo * that.number)

  def /(i: Int): Rational =
    new Rational(this.number, this.denmo * i)

  def lessThan(that: Rational): Boolean =
    this.number * that.denmo < that.number * this.denmo

  def max(that: Rational): Rational =
    if (this.lessThan(that)) that else this

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
