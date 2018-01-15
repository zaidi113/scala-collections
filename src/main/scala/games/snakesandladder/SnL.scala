package main.scala.games.snakesandladder

case class SnL(start: Int, end: Int) {
  override def toString: String = "Going From " + start + " To " + end
}

object SnL {

  def xapply(start: Int, end: Int) : SnL = new SnL(start, end)
}
