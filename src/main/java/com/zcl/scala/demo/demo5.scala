class Point(val x: Int, val y: Int)

trait Rectangular {
  def topLeft: Point

  def bottomRight: Point

  def left = topLeft.x

  def right = bottomRight.x

  def width = right - left
}

abstract class Component extends Rectangular {}

class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular {}

val rect = new Rectangle(new Point(1, 1), new Point(10, 10))