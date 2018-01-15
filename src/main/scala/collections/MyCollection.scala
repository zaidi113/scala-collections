package main.scala.collections

trait MyCollection[T] {

  def iterator(): Iterator[T]
  def add(t:T)
  def remove(t:T): Boolean
  def contains(t:T): Boolean
  def isEmpty: Boolean
  def size: Int

}
