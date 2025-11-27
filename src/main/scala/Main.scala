import scala.io.StdIn.{readLine, readInt}

object Main extends App {
// keeping global as multiple classes need access
  val morseCode: Map[Char, String] = Map(
    'A' -> ".-",
    'B' -> "-...",
    'C' -> "-.-.",
    'D' -> "-..",
    'E' -> ".",
    'F' -> "..-.",
    'G' -> "--.",
    'H' -> "....",
    'I' -> "..",
    'J' -> ".---",
    'K' -> "-.-",
    'L' -> ".-..",
    'M' -> "--",
    'N' -> "-.",
    'O' -> "---",
    'P' -> ".--.",
    'Q' -> "--.-",
    'R' -> ".-.",
    'S' -> "...",
    'T' -> "-",
    'U' -> "..-",
    'V' -> "...-",
    'W' -> ".--",
    'X' -> "-..-",
    'Y' -> "-.--",
    'Z' -> "--..",
    ' ' -> "/"
  )

  object Translator {}
  val (validInput, lang) = InputHandler.read()

  println("To translate: " + validInput.mkString("[", ", ", "]"))
  println("Language: " + lang)

}
