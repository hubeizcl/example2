import java.io.{File, FileNotFoundException}

def gcdloop(x: Long, y: Long): Long = {
  var a = x
  var b = y
  while (a != 0) {
    val temp = a
    a = b % a
    b = temp
  }
  b
}

var line = " "
do {
  line = readLine()
  println("Read: " + line)
} while (line != " ")

def greet(): Unit = {
  println("hi")
}

val filesHere = (new File(".")).listFiles()

for (file <- filesHere)
  println(file)

for (i <- 1 to 4)
  print(i)


for (i <- 1 until (4))
  print(i)

for (i <- 0 to filesHere.length - 1)
  print(filesHere(i))

val filesHere2 = (new File("")).listFiles()
for (file <- filesHere2 if file.isFile; if file.getName.endsWith(""))
  println(file)

for {file <- filesHere2 if file.isFile; if file.getName.endsWith("") if line <- fileLines(file) trimmed = line.trim if trimmed.matches("")}
  yield file

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

try {
  val f = new FileReader("")

} catch {
  case ex: FileNotFoundException =>
  case ex: IOException =>
} finally {
  f.close
}

import java.net.URL
import java.net.MalformedURLException

def urlFor(path: String) =
  try {
    new URL(path)
  } catch {
    case e: MalformedURLException => new URL("")
  }

val firstArg = if (args.length > 0) args(0) else ""

firstArg match {
  case "salt" => println("pepper")
  case "chips" => println("salsa")
  case "eggs" => println("bacon")
  case _ => println("huh?")
}


def makeRowSeq(row: Int) =
  for (col <- 1 to 10) yield {
    val prod = (row * col).toString
    val padding = " " * (4 - prod.length)
    padding + prod
  }
def makeRow(row: Int) = makeRowSeq(row).mkString

def mulitTable() = {
  val tableSeq =
    for (row <- 1 to 10)
      yield makeRow(row)
  tableSeq.mkString("\n")
}