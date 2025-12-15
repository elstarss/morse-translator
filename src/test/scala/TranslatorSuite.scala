import org.scalatest.funsuite.AnyFunSuite
import entities.Translator
import entities.Language


class TranslatorSuite extends AnyFunSuite {

  test("English to Morse: SOS") {
    val translator = new Translator(
      "SOS".split(" "),
      Language.ENGLISH
    )
    val obtained = translator.translate
    val expected = "... --- ..."
    assert(obtained == expected)
  }

  test("Morse to English: .... . .-.. .-.. ---") {
    val translator = new Translator(
      ".... . .-.. .-.. ---".split(" "),
      Language.MORSE
    )
    val obtained = translator.translate
    val expected = "HELLO"
    assert(obtained == expected)
  }

  test("Handles word separator") {
    val translator = new Translator(
      ".... . .-.. .-.. --- / .-- --- .-. .-.. -..".split(" "),
      Language.MORSE
    )
    val obtained = translator.translate
    val expected = "HELLO WORLD"
    assert(obtained == expected)
  }
}


val testShortcut = "~testOnly *TranslatorSuite"
