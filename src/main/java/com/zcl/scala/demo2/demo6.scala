import java.io.{File, PrintWriter}
import javax.management.Query

object FileMatcher {
  private def fileHere = new File(".").listFiles

  def fileEnding(query: String) =
  //    for (file <- fileHere; if file.getName.endsWith(query))
  //      yield file
    fileMatching(query, _.endsWith(_))

  def filescontaining(query: String) =

  //    for (file <- fileHere; if file.getName.contains(query))
  //      yield file
    fileMatching(query, _.contains(_))

  def filesRegex(query: String) =

  //    for (file <- fileHere; if file.getName.matches(query))
  //      yield file
    fileMatching(query, _.matches(_))

  def fileMatching(query: String, matcher: (String, String) => Boolean) = {
    for (file <- fileHere; if matcher(file.getName, query))
      yield file
  }

  def withPrintWriter(file: File, op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def main(args: Array[String]): Unit = {
    withPrintWriter(new File("date.text"), writer => writer.println(new java.util.Date()))
  }
}