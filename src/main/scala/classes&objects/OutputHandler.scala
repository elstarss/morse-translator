case class OutputHandler(val toOutput: String) {
  def output: Unit =
    println(s"Translation: $toOutput")
    println("Thanks, please restart the program to continue!")
}
