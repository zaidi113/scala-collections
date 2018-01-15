package scala.games.snakesandladder

import main.scala.games.snakesandladder.{Dice, Player}
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.scalatest.FunSuite

class PlayerTest extends FunSuite {

  test("multiple turns when user six scores") {

    val dice = Mockito.mock(classOf[Dice])
    Mockito.when(dice.roll()).thenReturn(6).thenReturn(6).thenReturn(4)

    val player = new Player("xx")
    assert(player.takeTurn(dice) == 16)

  }

}
