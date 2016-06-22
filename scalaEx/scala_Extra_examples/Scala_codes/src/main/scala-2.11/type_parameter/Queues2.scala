package type_parameter

/**
  * Created by Goduguluri on 6/20/2016.
  */
object Queues2 {
  class SlowHeadQueue[T](smele: List[T]) { // Not efficient
  // smele is elems reversed
  def head = smele.last
    def tail = smele.init
    def enqueue(x: T) = new SlowHeadQueue(x :: smele)
  }

  def main(args: Array[String]) {
    val q = new SlowHeadQueue(Nil) enqueue 1 enqueue 2 enqueue 3 enqueue 4
    println(q.tail)
  }
}