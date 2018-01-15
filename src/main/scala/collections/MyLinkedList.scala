package main.scala.collections

class MyLinkedList[T >: Null] extends MyList[T] {

  val node = ListElement(null, null)
  var last:ListElement= null

  var totalElements = 0

  override def add(t: T): Unit = {

    totalElements match {
      case 0 =>
        node.item = t
        last = node

      case _ =>
        val newElement = ListElement(t, last)
        last.next = newElement
        last = newElement
    }
    totalElements += 1
  }


  override def add(index: Int, t: T): Unit = {

    if(index > totalElements){
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + totalElements)
    }

    val existingElement : ListElement = element(index)
    val newEntry = ListElement(t, existingElement.previous)
    existingElement.previous.next = newEntry
    newEntry.next = existingElement

    totalElements += 1
  }

  override def remove(index: Int) : T = {

    if(index > totalElements){
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + totalElements)
    }
    removeElement(element(index))
  }

  override def remove(t: T): Boolean = {

    val toBeRemoved = findMatching(t)
    toBeRemoved match {
      case Some(f) => removeElement(f)
                      true
      case _ => false
    }
  }

  override def contains(t: T): Boolean = {
    findMatching(t) match {
      case Some(f) => true
      case _ => false
    }
  }

  override def get(index: Int) : T = {

    if(index > totalElements){
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + totalElements)
    }
    element(index).item
  }

  override def size: Int = totalElements

  override def isEmpty: Boolean = node.item == null


  override def iterator(): Iterator[T] = ???

  override def toString : String = {
    mkString(node, new StringBuilder())
  }

  private def element(index: Int) : ListElement = {


    val indexPointer: Int = (totalElements / 2).intValue
    val searchFromStart = indexPointer >= index
    var res:ListElement = null

    if(searchFromStart) {
      res = node
      for(i <- 0 until index ) {
        res = res.next
      }
      res

    } else {
      var res = last
      for(i <-  Range(totalElements -1 , indexPointer, -1) if i > index) {
        res = res.previous
      }
      res
    }
  }

  private def removeElement(toBeRemoved: ListElement): T = {

    val prev = toBeRemoved.previous
    val next = toBeRemoved.next

    prev.next = next
    next.previous = prev
    totalElements -= 1

    toBeRemoved.item

  }

  private def findMatching(t:T) : Option[ListElement] = {

    var res: Option[ListElement] = None
    var n = node
    var matched = false
    while(n != null && !matched){

      if(n.item == t){
        res = Some(n)
        matched = true
      }else {
        n = n.next
      }

    }
    res
  }

  def mkString(elem:ListElement, str:StringBuilder) : String = {

    str.append(elem.item.toString).append("<->")
    if(elem.next != null){
      mkString(elem.next, str)
    }
    str.toString()
  }

  case class ListElement (var item: T, var previous:ListElement) {
    var next:ListElement = _

  }
}
