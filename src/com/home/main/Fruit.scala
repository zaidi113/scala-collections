package com.home.main

class Fruit(val name: String, val colour: String) {

  override def toString: String = "Name:" + name + ", Colour:" + colour

}

object Fruit {

  def apply(name: String, colour: String): Fruit = {
    new Fruit(name, colour)
  }

  def unapply(f: Fruit): Option[String] = {
      Some(f.name)
  }

//  def unapply(f: Fruit): Option[(String, String)] = {
//    Some(f.name, f.colour)
//  }
//
//  def unapply(f: Fruit): Boolean = {
//    f.name == ""
//  }
}
