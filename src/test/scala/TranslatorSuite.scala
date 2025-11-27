import org.scalatest.funsuite.AnyFunSuite
import Main.Language

class TranslatorSuite extends AnyFunSuite {

  val morseCode: Map[Char, String] = Map(
    'A' -> ".-", 'B' -> "-...", 'C' -> "-.-.", 'D' -> "-..",
    'E' -> ".", 'F' -> "..-.", 'G' -> "--.", 'H' -> "....",
    'I' -> "..", 'J' -> ".---", 'K' -> "-.-", 'L' -> ".-..",
    'M' -> "--", 'N' -> "-.", 'O' -> "---", 'P' -> ".--.",
    'Q' -> "--.-", 'R' -> ".-.", 'S' -> "...", 'T' -> "-",
    'U' -> "..-", 'V' -> "...-", 'W' -> ".--", 'X' -> "-..-",
    'Y' -> "-.--", 'Z' -> "--..", ' ' -> "/", '.' -> ".-.-.-",
    ',' -> "--..--", '?' -> "..--..", '!' -> "-.-.--", ':' -> "---...",
    ';' -> "-.-.-.", '\'' -> ".--.-.", '"' -> ".-..-..-"
  )

  test("English to Morse: SOS") {
    val toTranslate = "SOS"
    val translator = Translator(toTranslate.split(" "), Language.English)
    val obtained = translator.translate
    val expected = "... --- ..."
    assert(obtained == expected)
  }
}


val testShortcut = "~testOnly *TranslatorSuite"
