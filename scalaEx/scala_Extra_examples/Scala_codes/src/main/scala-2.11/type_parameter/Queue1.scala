package type_parameter

/**
  * Created by Goduguluri on 6/20/2016.
  */
object Queues1 {
  class SlowAppendQueue[T](elems: List[T]) { // Not efficient
  def head = elems.head
    def tail = elems.tail
    def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x))
  }

  def main(args: Array[String]) {
    val q = new SlowAppendQueue(Nil) enqueue 1 enqueue 2 enqueue 3 enqueue 4
    println(q.tail)

  }
}
