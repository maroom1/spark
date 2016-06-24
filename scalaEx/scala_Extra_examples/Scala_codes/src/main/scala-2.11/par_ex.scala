/**
  * Created by Goduguluri on 6/23/2016.
  */
object par_ex extends  App{

  case class Person(name:String,age:Int)

  val person=Array(Person("1",10), Person("1",21), Person("1",31), Person("1",14), Person("1",1),
     Person("1",12),
   Person("1",81), Person("1",21), Person("1",18), Person("1",19))

  val d1=System.nanoTime()

val (minors,seniors)=person partition (_.age < 18)
val d2=System.nanoTime()
  println("withput prallalesism the statement executed in "+((d2-d1)/1000000000.0)+ "sec")
  minors.foreach(println)
 seniors.foreach(println)
  val d3=System.nanoTime()
  val (minors1,seniors1)=person.par partition (_.age < 18) // par will parallise the running
  val d4=System.nanoTime()
  println("with prallalesism the statement executed in "+((d4-d3)/1000000000.0)+ "sec")

  // the value of time changes for every run



  minors1.foreach(println)
  seniors1.foreach(println)

  //================================================================
  def typeByAge(p: Person): String =
    if(p.age < 4) "BABY"
    else if(p.age < 18) "MINOR"
    else if(p.age < 65) "ADULT"
    else "OLD"


  val g = person groupBy typeByAge

  val (babys,small,adults,olds) = (g("BABY"),g("MINOR"),g("ADULT"),g("OLD"))

  println("babies "+babys.length)

  println("MINOR "+small.length)

  println("ADULT "+adults.length)

  println("OLD "+olds.length)

//=========================
  Tuple3(person.filter(_.age < 18), person.filter(p => p.age > 18 && p.age < 65), person.filter(_.age > 65))




}
