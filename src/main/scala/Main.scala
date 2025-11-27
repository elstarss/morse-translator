object Main extends App {

  enum Language:
    case English, Morse

  val (validInput, lang) = InputHandler.read()

  val translator = new Translator(input = validInput, language = lang)
  val translatedText = translator.translate
  val outputHandler = OutputHandler(translatedText)
  outputHandler.output

}
