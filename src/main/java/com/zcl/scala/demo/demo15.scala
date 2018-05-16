import scala.collection.{mutable, immutable}

val stack = new mutable.Stack[Int]()
stack.push(1)
stack.pop()

def hasUpperCase(s: String) = s.exists(_.isUpper)

val text = "See Spot run. Run, Spot . Run!"
val wordArray = text.split("[ !,.]+")

val words = mutable.Set.empty[String]
for (word <- wordArray)
  words += word.toLowerCase

val map = mutable.Map.empty[String, Int]
map("hello") = 1
map("there") = 2

map("hello")


def countWords(text: String) = {
  val counts = mutable.Map.empty[String, Int]
  for (rawWord <- text.split("[ !,.]+")) {
    val word = rawWord.toLowerCase
    val oldCount = if (counts.contains(word)) counts(word) else 0
    counts += (word -> (oldCount + 1))
  }
  counts
}

countWords(text)

val nums = immutable.Map("i" -> 1, "ii" -> 2)
nums + ("vi" -> 3)
nums - "ii"
nums ++ List("iii" -> 3, "v" -> 4)
nums -- List("iii", "v")
nums.size
nums("i")
nums.keys
nums.keySet
nums.values
nums.isEmpty

val word = mutable.Map.empty[String, Int]
word += ("one" -> 1)
word -= ("one")
word ++= List("one" -> 1, "two" -> 2, "three" -> 3)
word --= List("one", "two")

val set = mutable.TreeSet(4, 6, 1, 3, 6, 10)

object MapMaker {
  def makeMap: mutable.Map[String, String] = {
    new mutable.HashMap[String, String]() with mutable.SynchronizedMap[String, String] {
      override def default(key: String): String = "why do you want to known?"
    }
  }
}

val capital = MapMaker.makeMap

capital ++ List("US" -> "Washington", "France" -> "Paris", "Japan" -> "Toky")
capital("New Zealand")

val mutaset = mutable.Set.empty ++ set
val immutaset = immutable.Set.empty ++ mutaset

def longestWord(words: Array[String]) = {
  var word = words(0)
  var idx = 0
  for (i <- 1 until words.length) {
    if (words(i).length > word.length) {
      word = words(i)
      idx = i
    }
    (word, idx)
  }
}
val longest=longestWord(text.split("[ !,.]+"))





