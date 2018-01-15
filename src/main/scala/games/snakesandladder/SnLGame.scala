package main.scala.games.snakesandladder

object SnLGame extends App{

  new Board(Player("Hasnain"),
            Player("Qasim"),
            Player("Ali-Akbar")
           ).play()

}
