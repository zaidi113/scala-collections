package main.scala.shopping

import scala.collection.mutable.Map

/**
 * Created by muhammadraza on 22/10/2016.
 */

object ProductCatalogue {


  val catalogue = Map[String, BigDecimal]()
  catalogue.+=("apple" -> BigDecimal(0.60))
  catalogue += ("orange" -> BigDecimal(0.25))
  catalogue += ("banana" -> BigDecimal(0.20))

  def getPrice(name: String): BigDecimal = catalogue.getOrElse(name, null)
  def productExists(name: String) = catalogue.contains(name)
  def availableProducts() = catalogue.foreach(println(_))

}
