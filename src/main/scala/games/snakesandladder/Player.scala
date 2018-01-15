package main.scala.games.snakesandladder

case class Player(name: String) {

  var position: Int = 1

  def takeTurn(d: Dice): Int = {
    rollDice(0, d)
  }

  def rollDice(score: Int = 0, d: Dice) : Int = {

    if(score != 0 && score % 6 != 0) score else { rollDice( score + d.roll(), d) }
  }

  override def toString: String = name
}
