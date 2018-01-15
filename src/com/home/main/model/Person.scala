package com.home.main.model

/**
 * Created by muhammadraza on 18/10/2016.
 */
class Person(fName: String, lName: String) {

  println(this)

  override def toString: String = "FirstName : " + fName + ", LastName : " + lName
}
