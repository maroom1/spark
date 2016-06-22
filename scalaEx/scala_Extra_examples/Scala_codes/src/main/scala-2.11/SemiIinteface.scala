object SemiInference extends App{

  /* This method has multiple statements on the same line,
   * so you need to write semicolons explicitly. */
  def printProd2() {
    val s = "hello"; println(s)
  }

  /* This method has just one statement.  The compiler
   * will not insert semicolons in the middle of an if. */
  def check(x: Int) {
    if (x < 2)
      println("too small")
    else
      println("ok")
  }

  check(1)
  check(3)
  printProd2()
}