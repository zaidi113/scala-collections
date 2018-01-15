package main.scala.collections

abstract class MyList[T] extends MyCollection[T] {

  def add(index:Int, t:T)
  def get(index:Int) :T
  def remove(index:Int): T

}
