List(1, 2, 3) map (_ + 1)
List.range(1, 5) flatMap (i => List.range(1, i) map (j => (i, j)))

for (i <- List.range(1, 5); j <- List.range(1, i)) yield (i, j)
var sum = 0
List(1, 2, 3) foreach (sum += _)

List(1, 2, 3) filter (_ % 2 == 0)
List(1, 2, 3) partition (_ % 2 == 0)

List(1, 2, 3) find (_ % 2 == 0)

List(1, 2, 3, -4, 5) takeWhile (_ > 0)

List(1, 2, 3, -4, 5) dropWhile (_ > 0)

List(1, 2, 3, -4, 5) span (_ > 0)

def hasZeroRow(m: List[List[Int]]) =
  m exists (row => row forall (_ == 0))

def sum(xs: List[Int]): Int = (0 /: xs) (_ + _)

sum(List(1, 2, 3, -4, 5))

def product(xs: List[Int]): Int =
  (1 /: xs) (_ * _)

product(List(1, 2, 3, -4, 5))

def flattenLeft[T](xss: List[List[T]]) =
  (List[T]() /: xss) (_ ::: _)

def flattenRight[T](xss: List[List[T]]) =
  (xss :\ List[T]()) (_ ::: _)

def reverseLeft[T](xs: List[T]) = (List[T]() /: xs) { (ys, y) => y :: ys }

List(1, 2, 3, -4, 5) sortWith (_ < _)

List.fill(5)("hello")

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

val buf = new ArrayBuffer[Int]()

buf += 12


import scala.collection.immutable.Queue

val empty = new Queue[Int]()

empty.enqueue(1).enqueue(List(2, 3)).enqueue(Set(4, 5))

val queue = new mutable.Queue[Int]()
queue ++= List(1, 2)
queue += 5
queue.dequeue()




