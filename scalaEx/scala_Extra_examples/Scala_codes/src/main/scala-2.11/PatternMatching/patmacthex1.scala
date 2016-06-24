/*
package PatternMatching

/**
  * Created by Goduguluri on 6/22/2016.
  */
object patmacthex1 extends App{
  def activity(day: String) {
    day match {
      case "Sunday" => print("Eat, sleep, repeat... ")
      case "Saturday" => print("Hangout with friends... ")
      case "Monday" => print("...code for fun...")
      case "Friday" => print("...read a good book...")
      case _ => print("Its another boring day")

    }
  }


  List("Monday", "Sunday", "Saturday","thatday").foreach { activity }

  object DayOfWeek extends Enumeration {
    val SUNDAY = Value("Sunday")
    val MONDAY = Value("Monday")
    val TUESDAY = Value("Tuesday")
    val WEDNESDAY = Value("Wednesday")
    val THURSDAY = Value("Thursday")
    val FRIDAY = Value("Friday")
    val SATURDAY = Value("Saturday")
  }


  def activity(day: DayOfWeek.Value) {
    day match {
      case DayOfWeek.SUNDAY => println("Eat, sleep, repeat...")
      case DayOfWeek.SATURDAY => println("Hangout with friends")
      case _ => println("...code for fun...")
    }
  }

  activity(DayOfWeek.SATURDAY)
  activity(DayOfWeek.MONDAY)


  def processCoordinates(input: Any) {
    input match {
      case (a, b) => printf("Processing (%d, %d)... ", a, b)
      case "done" => println("done")
      case _ => null
    }
  }


  processCoordinates((39, -104))
  processCoordinates("done")

/*
  array explosion symbol (_*):*/

  def processItems(items: List[String]) {
    items match {
      case List("apple", "ibm") => println("Apples and IBMs")
      case List("red", "blue", "white") => println("Stars and Stripes...")
      case List("red", "blue", _*) => println("colors red, blue, ... ")
      case List("apple", "orange", otherFruits @ _*) =>
        println("apples, oranges, and " + otherFruits)
    }
  }

  processItems(List("apple", "ibm"))
  processItems(List("red", "blue", "green"))
  processItems(List("red", "blue", "white"))
  processItems(List("apple", "orange", "grapes", "dates"))


  def process(input: Any) {
    input match {
    case (a: Int, b: Int) => print("Processing (int, int)... ")
    case (a: Double, b: Double) => print("Processing (double, double)... ")
    case msg : Int if (msg > 1000000) => println("Processing int > 1000000")
    case msg : Int => print("Processing int... ")
    case msg: String => println("Processing string... ")
    case _ => printf("Can't handle %s... ", input)
    }
     }


  process((34.2, -159.3))
  process(0)
  process(1000001)
  process(2.2)
/*
  Scala expects the pattern variables to start with a lowercase letter and
    expects constants to start with an uppercase letter.*/
  class Sample {
  val max = 100
  val MIN = 0

  def process(input: Int) {
    input match {
      case max => println("Don't try this at home") // Compiler error
      case MIN => println("You matched min")
      case _ => println("Unreachable!!")
    }
  }

// IF WE INTERCHANGE THE ABOVE CASES WE GET DIFF OUTPUT

}


  new Sample().process(100)
  new Sample().process(0)
  new Sample().process(10)



  class Sample1 {
    val max = 100
    val MIN = 0
    def process(input: Int) {
      input match {
        case this.max => println("You matched max")
        case MIN => println("You matched min")
        case _ => println("Unmatched")
      }
    }
  }
  new Sample1().process(100)
  new Sample1().process(0)
  new Sample1().process(10)


  abstract case class Trade()
 // sealed abstract case class Trade()

  case class Sell(stockSymbol: String, quantity: Int) extends Trade
  case class Buy(stockSymbol: String, quantity: Int) extends Trade
  case class Hedge(stockSymbol: String, quantity: Int) extends Trade

  /*In processTransaction( ), we did not match all possible types of Trades;
  we skipped Hedge. This will be a problem at runtime if a Hedge is
  received. However, Scala does not know how many case classes inherit
    from Trade. After all, we may have extended other case classes in other
  files. Scala can, however, help if we tell Scala that we have no more
    classes than presented in this file. We can do this by using an unusual
  combination of sealed abstract, as shown here   see above statement*/

  class TradeProcessor {
    def processTransaction(request : Trade) {
      request match {
        case Sell(stock, 1000) => println("Selling 1000-units of " + stock)
        case Sell(stock, quantity) =>
          printf("Selling %d units of %s\n", quantity, stock)
        case Buy(stock, quantity) if (quantity > 2000) =>
          printf("Buying %d (large) units of %s\n", quantity, stock)
        case Buy(stock, quantity) =>
          printf("Buying %d units of %s\n", quantity, stock)
      }
    }
  }

  val tradeProcessor = new TradeProcessor
  tradeProcessor.processTransaction(Sell("GOOG", 500))
  tradeProcessor.processTransaction(Buy("GOOG", 700))
  tradeProcessor.processTransaction(Sell("GOOG", 1000))
  tradeProcessor.processTransaction(Buy("GOOG", 3000))

  import scala.actors._
  import Actor._
  case class Apple()
  case class Orange()
  case class Book ()
  class ThingsAcceptor {
    def acceptStuff(thing: Any) {
      thing match {
        case Apple() => println("Thanks for the Apple")
        case Orange() => println("Thanks for the Orange")
        case Book() => println("Thanks for the Book")
        case _ => println("Excuse me, why did you send me a " + thing)
      }
    }
  }

  val acceptor = new ThingsAcceptor
  acceptor.acceptStuff(Apple())
  acceptor.acceptStuff(Book())
  acceptor.acceptStuff(Apple)

  object StockService {
    def process(input : String) {
      input match {
        case Symbol2() => println("Look up price for valid symbol " + input)
        case _ => println("Invalid input " + input)
      }
    }
  }

  object Symbol2 {
    def unapply(symbol : String) : Boolean = symbol == "GOOG" || symbol == "IBM"
    // you'd look up database above... here only GOOG and IBM are recognized
  }


}
*/
