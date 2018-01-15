package main.scala.collections

class MyMap[K, V] {

  val items:Array[List[Entry]] = new Array[List[Entry]](100)
  var itemsCount: Int = 0

  def put(key:K, value:V): Unit = {
    val idx = calcIndex(key)
    if(items(idx) == null){
      items(idx) = List(Entry(key, value))
      itemsCount += 1
    }else {
      val existingEntry: Option[Entry] = items(idx).find(e => e.key == key)
      if(existingEntry.isDefined){
        existingEntry.get.value = value
      }else {
        items(idx) = Entry(key,value) :: items(idx)
        itemsCount += 1
      }
    }
  }

  def get(k:K) : Option[V] = {
    findEntry(k).map(_.value)
  }

  def remove(key: K) : Option[V] = {
    val idx = calcIndex(key)
    val entries = items(idx)
    entries match {
      case List() => None
      case _ =>
        val partitions = entries.partition(e => isEqual(e, key))
        items(idx) = partitions._2
        partitions._1.headOption.map(e => {itemsCount -= 1; e.value})
    }
  }

  override def toString: String = {
    items.mkString("|")
  }

  def containsKey(k: K): Boolean = {
    get(k).isDefined
  }

  def isEmpty: Boolean = itemsCount == 0

  def size(): Int = {
    itemsCount
  }

  def iterator(): Iterator[Entry] = {
    val entries = for (entryList <- items; if entryList != null; entry <- entryList) yield entry
    entries.iterator
  }


  private def findEntry(k: K): Option[Entry] = {
    val idx = calcIndex(k)
    val entries = items(idx)
    entries match {
      case null | List() => None
      case lst => lst.find(e => isEqual(e, k))
    }
  }

  private def isEqual(entry:Entry, s2:K) : Boolean = {
    entry.key == s2
  }

  private def calcIndex(k:K): Int = {
    if(k == null ) 0 else k.hashCode() % 100
  }

  case class Entry(key:K, var value:V)

}
