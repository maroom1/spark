/**
  * Created by Goduguluri on 6/17/2016.
  */
object Basic2 extends App{
val greet=new Array[String](3)
  greet(0)="Hello"
  greet(1)=","
  greet(2)="World"
  for (i <- 0 to 2)
    println(greet(i))
  greet.foreach(x=>println(x))


}
