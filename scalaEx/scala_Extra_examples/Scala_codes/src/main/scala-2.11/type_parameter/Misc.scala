package type_parameter

/**
  * Created by Goduguluri on 6/20/2016.
  */
object Misc {
  class Cell[T](init: T) {
    private[this] var current = init
    def get = current
    def set(x: T) { current = x }
  }
  trait OutputChannel[-T] {
    def write(x: T)
  }
  trait Function1[-S, +T] {
    def apply(x: S): T
  }
}
