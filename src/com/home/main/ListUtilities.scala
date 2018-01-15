package com.home.main

/**
 * Created by muhammadraza on 21/09/2016.
 */
class ListUtilities {

  def penultimate(elems:List[String]): String = {
    assert(elems.nonEmpty)
    val idx = elems.length - 2
    elems(idx)
  }

}

object ListUtilities {

  def test() {
    var lu = new ListUtilities()
    println(lu.penultimate(List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")))
  }




}
