import scala.io.StdIn.{readLine, readInt}
import Main.Language

object InputHandler {

  /*  returning a tuple with the validated string and language type */
  def read(): (Array[String], Language) = {
    println(
      "Let me know what I should translate! Make sure to separate any morse code using a slash and a space' / ' :"
    )

    // loops until input is valid
    val (input, language) = Iterator
      .continually {
        val rawInput = readLine()
        val rawInputToUpperCase = rawInput.toUpperCase()
        // calls validate input func
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
    val validatedInput = input.trim.split("\\s+").filterNot(_.isEmpty)
    return (validatedInput, language)
  }

  private def isPlainEnglish(s: String): Boolean =
    s.forall(char => MorseCode.englishToMorse.contains(char))
  private def isMorseCode(s: String): Boolean =
    s.forall(char => char == '.' || char == '-' || char == ' ' || char == '/')
  private def validateInput(s: String): Either[String, Language] =
    (isPlainEnglish(s), isMorseCode(s)) match {
      case (true, false) => Right(Language.English)
      case (false, true) => Right(Language.Morse)
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
