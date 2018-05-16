def inser(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y :: ys => if (x <= y) x :: xs else y :: inser(x, ys)
}
def isort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case x :: xsl => inser(x, isort(xsl))
}

def append(xs: List[Int], ys: List[Int]): List[Int] = xs match {
  case List() => List()
  case x :: xls => x :: append(xls, ys)
}

val nums = List(1, 2, 3) ::: List(4, 5, 6)

nums.last
nums.init
nums.reverse

nums.take(2)
nums.drop(2)
nums.splitAt(2)

nums.apply(2)
nums.indices

val obj = List("1", "2", "3") ::: List("3", "4", "6")
nums zip obj

obj mkString("[",",","]")

obj.toArray
obj.toArray.toList

obj copyToArray (new Array[String](10),2)



