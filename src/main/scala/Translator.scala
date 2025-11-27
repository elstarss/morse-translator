import Main.Language
class Translator(val input: Array[String], val language: Language) {
  val englishToMorseMap: Map[Char, String] = morseCode
  val morseToEnglishMap: Map[String, Char] = morseCode.map(_.swap)

  def translate: String =
    if language == Language.English then translateEnglishToMorse(input)
    else translateMorseToEnglish(input)

  private def translateEnglishToMorse(words: Array[String]): String =
    words
      .map(_.toUpperCase)
      .map(word =>
        word
          .map(ch => englishToMorseMap(ch))
          .mkString(" ")
      )
      .mkString(" / ")

  private def translateMorseToEnglish(input: Array[String]): String =
    input
      .map(morse =>
        println(morse)
        morseToEnglishMap(morse)
      )
      .mkString
}
