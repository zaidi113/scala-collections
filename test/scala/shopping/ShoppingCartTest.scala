package scala.shopping

import main.scala.shopping.{ProductType, ShoppingCart}
import org.junit.Assert._
import org.junit.{Before, Test}

import scala.math._


/**
 * Created by muhammadraza on 19/10/2016.
 */
class ShoppingCartTest {


  var cart = new ShoppingCart()
  val apple = ProductType.APPLE.toString
  val banana = ProductType.ORANGE.toString

  @Before def initilize() : Unit= {
    cart.addProduct(apple)
    cart.addProduct(apple)
    cart.addProduct(banana)
    cart.addProduct(apple)
  }

  @Test
  def testTotal() = {
    assertEquals(BigDecimal(2.0), cart.getOrderTotal)
  }

  @Test
  def testCartSummary() = {
    val summary: String = cart.preparePrintableSummary
    assertEquals(apple+ ", " + apple + ", " + banana + ", " + apple, summary)
  }

  @Test
  def foo() = {

  }

}
