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
  enum Language:
    case English, Morse

  object Translator {}
  val (validInput, lang) = InputHandler.read()

  val translator = new Translator(input = validInput, language = lang)
  println(s"translating ${validInput.mkString("//")}")
  println(translator.translate)
  val toTranslate = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
}
