package entities

object OutputHandler {
    def output(toOutput: String): Unit =
      println(s"Translation: $toOutput")
      println("Thanks, please restart the program to continue!")
}
