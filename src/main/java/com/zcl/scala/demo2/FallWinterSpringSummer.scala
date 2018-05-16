

object FallWinterSpringSummer extends scala.App {
  for (season <- List("fail", "winter", "spring"))
    println(season + ":" + calculate(season))
}
