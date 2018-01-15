package com.home.main.collections

import com.home.main.UnitSpec
import main.scala.collections.MyLinkedList

class MyLinkedListSpec extends UnitSpec {

  var list: MyLinkedList[String] = _

  it should " be able to add and retrieve elements " in {

    list = new MyLinkedList[String]()
    assert(list.isEmpty)

    list.add("S1")
    list.add("S2")
    list.add("S3")
    list.add("S4")
    list.add("S5")
    list.add("S6")
    list.add("S7")

    assert(!list.isEmpty)
    list.size should be (7)

    list.get(0) should be ("S1")
    assertResult("S2") {
      list.get(1)
    }
    assertResult("S4") {list.get(3)}
    assertResult("S6") {list.get(5)}
    assertResult("S7") {list.get(6)}

    list.add(3, "S3a")

    list.size should be (8)

    assertResult("S3a") {list.get(3)}
    assertResult("S4") {list.get(4)}
  }

  it should " be possible to remove elements " in {

    list = new MyLinkedList[String]()

    list.isEmpty

    list.add("S1")
    list.add("S2")
    list.add("S3")
    list.add("S4")
    list.add("S5")

    assertResult(5) {list.size}
    assertResult("S2") {list.get(1)}
    list.remove(1)
    assertResult("S3") {list.get(1)}

    assertResult(4) {list.size}

    assertResult(true) {list.contains("S3")}
    assert(list.remove("S3"))
    assertResult(false) {list.contains("S3")}
    assertResult(3) {list.size}
  }

}
