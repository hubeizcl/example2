val fruit = "apple" :: ("orange" :: ("pears" :: Nil))
val empty = Nil
val nums = 1 :: 2 :: 3 :: 4 :: Nil

fruit.tail.head
fruit.tail.tail.head

def insert(i: Int, xs: List[Int]): List[Int] = {
  if (xs.isEmpty || i <= xs.head) i :: xs
  else xs.head :: insert(i, xs.tail)
}

def isort(xs: List[Int]): List[Int] = {
  if (xs isEmpty) Nil
  else insert(xs.head, isort(xs.tail))
}
isort(List(1, 5, 10, -2, 9, 0, 100))

val List(a, b, c) = fruit

val a1 :: b1 :: rest :: c1 = fruit
val a2 :: b2 = fruit