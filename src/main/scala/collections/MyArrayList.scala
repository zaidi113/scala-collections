package main.scala.collections

class MyArrayList[T: Manifest](capacity:Int) extends MyList[T] {

  def this() = {
    this(10)
  }

  private var itemsSize = 0
  private val NULL_ELEMENT: T = null.asInstanceOf[T]
  private var items: Array[T] = new Array[T](capacity)

  override def isEmpty: Boolean = itemsSize == 0

  override def size: Int = itemsSize

  override def get(index: Int) : T = {
    if(itemsSize > index){
      return items(index)
    }
    throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + itemsSize)
  }

  override def add(t:T) = {
    items = resize()
    val idx = if(isEmpty) 0 else itemsSize
    items(idx) = t
    itemsSize += 1
  }

  override def add(index:Int, t:T): Unit = {
    if(itemsSize < index) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + itemsSize)
    }
    items(index) = t
  }

  override def remove(index: Int): T = {

    if(itemsSize < index) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + itemsSize)
    }
    val item = items(index)
    val newArray = new Array[T](items.length)
    Array.copy(items, index + 1 , newArray, 0, itemsSize - index)
    items = items.dropRight(items.length - index)
    items = items ++ newArray
    itemsSize -= 1

    item
  }

  override def contains(t: T): Boolean = {
    items.indexOf(t) > -1
  }

  override def remove(t:T) : Boolean = {

    val index: Int = items.indexOf(t)
    index match {
      case -1 => false
      case i => {
        remove(index)
        true
      }
    }

  }

  override def iterator(): Iterator[T] = {
    items.iterator
  }

  override def toString: String = {
    items.filter(e => e!=null).mkString("|")
  }

  private def resize(): Array[T] = {
    if(items.length <= itemsSize){
      val newArray = new Array[T](items.length * 2)
      Array.copy(items, 0, newArray, 0, items.length)
      newArray
    }else {
      items
    }
  }
}

object MyArrayList {

  def apply[T:Manifest](cap:Int): MyArrayList[T] = {
    new MyArrayList[T](cap)
  }
}

