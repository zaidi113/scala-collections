package main.scala.shopping

import scala.collection.immutable.Iterable
import scala.math.BigDecimal.RoundingMode
import scala.math._

/**
 * Created by muhammadraza on 19/10/2016.
 */
class ShoppingCart {

  var cart = List[Fruit]()

  def addProduct(prodName: String) : Boolean = {
    if(ProductCatalogue.productExists(prodName)) {
      cart = new Fruit(prodName, BigDecimal(0,60)) :: cart
      return true
    }
    false
  }

  def printOrderSummary = println("["+ preparePrintableSummary + "] => £ " + getOrderTotal)

  def preparePrintableSummary = {
    val groupedItems: Map[String, List[Fruit]] = cart.reverse.groupBy(_.name)
    val strs: Iterable[String] = groupedItems.map(entry => entry._1 + " * " + entry._2.length)
    strs.mkString(", ")
  }

  def getOrderTotal = {

    val itemGroup = cart.groupBy(_.name)
    itemGroup.map(item => applyDiscount(item._1, item._2.size)).sum.setScale(2, RoundingMode.HALF_EVEN)
  }

  def applyDiscount(prd: String, quantity: Int): BigDecimal = {

    prd match  {
        case "apple" => ceil(quantity.toFloat/2) * ProductCatalogue.getPrice(prd)
        case "orange" => (quantity - quantity/3)  * ProductCatalogue.getPrice(prd)
        case _ => quantity * ProductCatalogue.getPrice(prd)
    }
  }

}
