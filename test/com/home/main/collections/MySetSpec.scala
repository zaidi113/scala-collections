package com.home.main.collections

import com.home.main.UnitSpec
import main.scala.collections.{MySet, MyMap}

class MySetSpec extends UnitSpec {

  it should "add and remove elements" in {

    val set = new MySet[String]()
    assert(set.isEmpty)
    set.add("k1")
    set.add("k2")

    assertResult(2){ set.size}
    assert(set.contains("k1"))

    set.remove("k2")
    assertResult(1){ set.size }
    assert(!set.contains("k2"))

  }

  "Contains" should "return false for non-existent elements" in {

    val set = new MySet[String]()
    set.add("S1")
    assert(set.contains("S1"))
    assertResult(false) {set.contains("S2")}
  }

  it should "throw exception when null is added" in {

    val set = new MySet[String]()
    assertThrows[NullPointerException] {
      set.add(null)
    }
    assert(set.isEmpty)
  }

  it should "not allow duplicate elements" in {

    val set = new MySet[String]()
    assert(set.isEmpty)
    set.add("k1")
    set.add("k2")

    assertResult(2){ set.size}
    assert(set.contains("k1"))

    //should override previous - size should be same as before
    set.add("k1")
    assertResult(2){ set.size }
  }

  it should "create iterator on entries" in {

    val map = new MySet[String]()
    assert(map.isEmpty)
    map.add("k1")
    map.add("k2")

    val expectedElements = List("k1", "k2")
    map.iterator().foreach(e => {
      if(!expectedElements.contains(e)) {
        fail(e + " key not found in the iterator ")
      }
    })
  }

  class DummyKey(val text:String) {

    override def equals(that: scala.Any): Boolean = {
      that match {
        case that: DummyKey => text == that.text
        case _ => false
      }
    }
    override def hashCode(): Int = 1
  }
}