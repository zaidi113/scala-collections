package com.home.main

object FirstPartialFunction {

  def safeDiv: PartialFunction[(Int, Int), Int] = {

    case (a,b) if b != 0 => a/b
  }

  def main(args: Array[String]): Unit = {

    if(safeDiv.isDefinedAt(15, 0)){
      println(safeDiv(15, 0))
    } else {
      println("Invalid Division Parts!!!")
    }
  }

}
