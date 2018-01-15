package com.home.main.collections

import com.home.main.UnitSpec
import main.scala.collections.MyArrayList

class MyArrayListSpec extends UnitSpec {


  it should " support add and get elements" in {

    val list = MyArrayList[String](2)

    assert(list.isEmpty)

    list.add("S1")
    list.add("S2")
    list.add("S3")

    println(list)

    assert(!list.isEmpty)
    assertResult(3) {list.size}

    assertResult("S2") {list.get(1)}

    list.add(1, "S4")
    assert("S4" == list.get(1))

    assertThrows[IndexOutOfBoundsException] {
      list.get(4)
    }

  }

  it should "be possible to remove elements " in {

    val list = new MyArrayList[String](10)

    assert(list.isEmpty)

    list.add("S1")
    list.add("S2")
    list.add("S3")
    list.add("S4")
    list.add("S5")

    assert(5 == list.size)

    assert("S2" == list.get(1))
    list.remove("S2")
    assert("S3" == list.get(1))
    assert(4 == list.size)

    assert("S4" == list.get(2))
    list.remove(2)
    assert("S5" == list.get(2))
    assert(3 == list.size)
  }

  it should " return correct value for contains " in {

    val list = new MyArrayList[String](10)

    assert(list.isEmpty)

    list.add("S1")
    list.add("S2")
    list.add("S3")
    list.add("S4")

    assert(list.contains("S3"))
    assert(!list.contains("BLAHHH"))
  }

}
