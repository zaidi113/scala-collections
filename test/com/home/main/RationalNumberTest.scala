package com.home.main

import scala.util.Random

object RationalNumberTest extends App{

  val r = Random
  var range = 1 to r.nextInt(3)

  def randomPairs(n: Int) : List[(Int, Int)] = {
    for(i <- (1 until n).toList ) yield {
      (r.nextInt(100), r.nextInt(100))
    }
  }
}
