import scala.io.StdIn.{readLine, readInt}
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

object InputHandler {

  /*  returning a tuple with the validated string and language type */
  def read(): (Array[String], String) = {
    println("Let me know what I should translate! :")

    // loops until input is valid
    val (input, language) = Iterator
      .continually {
        val rawInput = readLine()
        val rawInputToUpperCase = rawInput.toUpperCase()
        validateInput(rawInputToUpperCase) match {
          case Right(lang) =>
            println(s"valid $lang input")
            Some(rawInputToUpperCase, lang)
          case Left(errorMsg) =>
            println(errorMsg)
            println("Please try inputting your text to be translated again:")
            None
        }
      }
      .collectFirst { case Some(value) => value }
      .get

    println(s"Okay, you said: $input")

    // returning a fully valid input
    val validatedInput = input.split(" ")
    return (validatedInput, language)
  }

  def isPlainEnglish(s: String): Boolean =
    s.forall(char => morseCode.contains(char))
  def isMorseCode(s: String): Boolean =
    s.forall(char => char == '.' || char == '-' || char == ' ')
  def validateInput(s: String): Either[String, String] =
    (isPlainEnglish(s), isMorseCode(s)) match {
      case (true, false) => Right("english")
      case (false, true) => Right("morse")
      case (false, false) =>
        Left(
          "Invalid: contains unsupported characters. Please refer to the mapping to see which characters are supported."
        )
      case (true, true) =>
        Left(
          "Invalid: text contains mixed plain text and morse code. Please pick a language to translate."
        )
    }

}
