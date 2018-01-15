package main.scala.games.snakesandladder

class Board(players: Player*) {

  println("Players Are [" + players.mkString(", ")+"]")

  val TOO_MUCH_SCORE_MESSAGE = "You got too much!!! Wait for next turn"
  val WINNING_SCORE = 100
  val createSnL = (start: Int, end: Int) => start -> SnL(start, end)
  val snakesAndLadders = {

    Map[Int, SnL](createSnL(4, 16), createSnL(14, 34), createSnL(20, 75), createSnL(70, 33), createSnL(39, 8), createSnL(18, 2) )
  }
  val dice = new Dice()

  def play(): Unit = {
    println("---------------------- START OF THE PLAY -------------------------")
    while (!hasWinner){

      players.foreach(playD)
      println("---------- NEXT ROUND ------------")
      Thread.sleep(1000)
    }
    println("WINNER IS " + players.find(winner).head)

  }

  private def playD(p: Player): Unit = {
    val score = p.takeTurn(dice)
    p.position = calculateNewPosition(p, score)
    println(p + " scored " + score + ", new position " + p.position)
  }

  private def hasWinner: Boolean = {
    players.exists(winner)
  }

  private def calculateNewPosition(p: Player, score: Int) : Int = {

    val newPos = applySnakesAndLadders(p.position + score)
    applyScore(newPos, p.position)
  }

  private def applySnakesAndLadders(pos: Int) : Int = {
    val snl = snakesAndLadders.getOrElse(pos, new SnL(0, pos))
    alert(snl)
    snl.end
  }

  val winner = (p: Player) => p.position == WINNING_SCORE

  val canUseScore = (pos: Int) => pos <= WINNING_SCORE

  val applyScore = (newPos: Int, oldPos: Int) => {
    if (newPos <= WINNING_SCORE) newPos else {println(TOO_MUCH_SCORE_MESSAGE); oldPos}
  }

  def alert(snl: SnL): SnL = {

      if (snl.start > snl.end) {
        println("Bitten by snake " + snl)
      }else if(snl.start > 0 ){
        println("Lucky !!! Found Ladder " + snl)
      }

    snl
  }


}
