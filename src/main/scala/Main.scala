import scala.io.StdIn.{readLine, readInt}

object Main extends App {
// keeping global as multiple classes need access

  enum Language:
    case English, Morse

  val (validInput, lang) = InputHandler.read()

  val translator = new Translator(input = validInput, language = lang)
  val translatedText = translator.translate
  val outputHandler = OutputHandler(translatedText)
  outputHandler.output

}
