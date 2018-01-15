package com.home.main

/**
 * Created by muhammadraza on 23/09/2016.
 */
class Fibonacci {

  def calculate(howmany: Int) {

    var n_1: Long = 0
    var n_2: Long = 1
    var n: Long = 0

    println(n_1)
    println(n_2)

    for( x <- 1 to howmany ){

      n = n_1 + n_2
      println(n)

      n_1 = n_2
      n_2 = n
    }
  }
}

object Fibonacci {

  def main(args: Array[String]) {
    val f = new Fibonacci()
    f.calculate(20)
  }
}