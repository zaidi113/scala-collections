package main.scala.collections

class MySet[T] extends MyCollection[T]{

  val items:MyMap[T,T] = new MyMap[T,T]

  override def add(t: T): Unit = {
    t match {
      case null => throw new NullPointerException("")
      case _ => items.put(t, t)
    }
  }

  def addAll(items: MyCollection[T]): Unit = {

  }

  override def size: Int = items.size()

  override def remove(t: T): Boolean = {
    items.remove(t).isDefined

  }

  override def contains(t: T): Boolean = {
    items.containsKey(t)
  }

  override def isEmpty: Boolean = items.isEmpty

  override def iterator(): Iterator[T] = {
    items.iterator().map(e => e.key)
  }
}
