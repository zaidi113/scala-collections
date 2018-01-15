package com.home.main

object StringUtilities {

  // match "movies 80301"
  val MoviesZipRE = "movies (\\d{5})".r
  // match "movies near boulder, co"
  val MoviesNearCityStateRE = "movies near ([a-z]+), ([a-z]{2})".r

  def matchByRegex(userText: String)  {

    userText match {

       case MoviesZipRE(xx) => println("ZIP Matched " + xx)
       case MoviesNearCityStateRE(xx, yy) => println("2 grops " + xx + "--" )
       case _ => println("No Match Found")

    }

  }

  def main(args: Array[String]) : Unit = {

    val s1 = "movies 80301"
    val s2 = "movies 99676"
    val s3 = "movies near boulder, co, Test"
    val s4 = "movies near talkeetna, ak"

    matchByRegex(s1)
    matchByRegex(s2)
    matchByRegex(s3)
    matchByRegex(s4)
  }


}
