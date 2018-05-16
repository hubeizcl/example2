def show(x: Option[String]) = x match {
  case Some(s) => s
  case None => "?"
}
val capitals = Map("France" -> "Paris", "Japan" -> "Toky")

show(capitals get "France")
show(capitals get "North Pole")

val myTuble = (123, "abc")
val (number, string) = myTuble

val withDefault: Option[Int] => Int = {
  case Some(x) => x
  case None => 0
}

