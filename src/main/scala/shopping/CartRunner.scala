package main.scala.shopping

/**
 * Created by muhammadraza on 22/10/2016.
 */
object CartRunner extends App {


  var checkout = false
  println("Begin Shopping : Enter Product Name to add to cart, 'e' for checkout, 'l' for Items Available." +
    ", 'v' for viewing cart.")
  var cart = new ShoppingCart()
  while (!checkout) {

    val ln = scala.io.StdIn.readLine()

    ln match {

        case "e" => cart.printOrderSummary; checkout = true
        case "l" => ProductCatalogue.availableProducts
        case "v" => cart.printOrderSummary
        case _ => addProduct(ln)
    }

  }


  def addProduct(name: String) = {
//    println("Adding " + name + " to your shopping basket. ")
    if(!cart.addProduct(name)) println("Opps... No such product exists!!")
    cart.printOrderSummary
  }

}
