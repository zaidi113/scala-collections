package com.home.main

object MatchUtilities extends App {

  val f = Fruit("Apple", "Red")

  f match {

    case Fruit(n) => println(" Name Is " + n)
    case _ => println(" . . . No match . . . ")

  }


}
