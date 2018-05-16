//import java.math.BigInteger
//
//import scala.collection.mutable
//import scala.io.Source
//
//def max(x: Int, y: Int): Int = if (x > y) x else y
//
//println(max(1, 2))
//
//var i = 0
//while (i < args.length) {
//  if (i != 0)
//    print(" ")
//  print(args(i))
//  i += 1
//}
//
//args.foreach((arg: String) => println(arg))
//args.foreach(println)
//for (arg <- args) println(arg)
//
//val big = new BigInteger("123456")
//val greetStrings = new Array[String](3)
//greetStrings(0) = "Hello"
//greetStrings(1) = ","
//greetStrings(2) = "world!"
//
//val greetString: Array[String] = new Array[String](3)
//greetString.update(0, "hello")
//greetString.update(1, "")
//greetString.update(2, "world")
//
//val numNumber = Array(1, 2, 3)
//val numNumber2 = Array.apply(1, 2, 3)
//
//for (i <- 0 to 2) {
//  print(greetStrings(i))
//}
//val onetwo = List(1, 2)
//val threeFour = List(3, 4)
//val oneTwoThreeFour = onetwo ::: threeFour
//print(1 :: onetwo)
//val oneTwoThree = 1 :: 2 :: 3 :: Nil
//
//val pair = (99, "luffballons")
//println(pair._1)
//println(pair._2)
//
//val jetSet: Set[String] = Set("boeing", "airbus")
//jetSet.apply("learn")
//println(jetSet.contains("cessna"))
//
//val movieSet = scala.collection.mutable.Set("hitch", "poltergeist")
//movieSet += "sherk"
//println(movieSet)
//
//val hashset = mutable.HashSet("tomatoes", "chilles")
//println(hashset)
//val treasuremap = mutable.Map[Int, String]()
//
//treasuremap += (1 -> "go to island")
//treasuremap += (2 -> "find big x on ground")
//treasuremap += (3 -> "dig.")
//println(treasuremap(2))
//
//val romanNumberal = Map(
//  1 -> "1", 2 -> "2", 3 -> "3"
//)
//println(romanNumberal(2))
//
//def printArgs(args: Array[String]): Unit = {
//  var i = 0
//  while (i < args.length) {
//    print(args(i))
//    i += 1
//  }
//}
//
//def printArgs2(args: Array[String]): Unit = {
//  for (arg <- args) {
//    println(arg)
//  }
//}
//
//def formatArgs(args: Array[String]) = args.mkString("\n")
//
//if (args.length > 0) {
//  for (line <- Source.fromFile(args(0)).getLines())
//    print(line.length + " " + line)
//} else {
//  Console.err.println("Please enter filename")
//}
//
////
////var maxWidth = 0
////for (line <- lines)
////  maxWidth = maxWidth.max(widthOfLines(line))
//
//def widthOfLines(s: String) = s.length.toString.length
//
//if (args.length > 0) {
//  val lines = Source.fromFile(args(0)).getLines().toList
//  val longstLine = lines.reduceLeft((a, b) => if (a.length > b.length) a else b)
//  val maxWidths = widthOfLines(longstLine)
//  for (line <- lines) {
//    val numSpaces = maxWidths - widthOfLines(line)
//    val padding = " " * numSpaces
//    print(padding + line.length + "|" + line)
//  }
//
//} else {
//  Console.err.println("Please enter filename")
//}
//
//
//
