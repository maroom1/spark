import java.io._
import java.util._

trait Logger9 {
  println("Constructing Logger9")
  def log(msg: String)
}

trait FileLogger9 extends Logger9 {
  println("Constructing FileLogger9")

  val out = new PrintWriter("app.log") // Part of the traits constructor
  out.println("# " + new Date().toString) // Also part of the constructor
  out.flush();
  def log(msg: String) { 
    println("filelog msg :"+msg)
    out.println(msg); out.flush() }
}

trait ShortLogger9 extends Logger9 {
  println("Constructing ShortLogger9")

  val maxLength: Int // An abstract field
  println(maxLength)
  abstract override def log(msg: String) {
    println("override msg :"+msg)
    super.log(
      if (msg.length <= maxLength) 
      { 
        println(msg.length +""+ maxLength)
        msg } 
      else msg.substring(0, maxLength - 3) + "...")
  }
}

class Account9 {
  println("Constructing Account9")

  protected var balance = 0.0
}

class SavingsAccount9 extends Account9 with FileLogger9 with ShortLogger9 {
  println("Constructing SavingsAccount9")

  val maxLength = 15
  def withdraw(amount: Double) {
    if (amount > balance) log("We are Sorry.. No funds..!!")
    else balance -= amount
  }

  // More methods ...
}

object Main9 extends App {
  val acct = new SavingsAccount9
  acct.withdraw(100) 
  //println("Look into myapp.log for the log message.");
}