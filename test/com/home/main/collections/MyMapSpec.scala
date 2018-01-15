package com.home.main.collections

import com.home.main.UnitSpec
import main.scala.collections.MyMap

class MyMapSpec extends UnitSpec {

  it should "add and retrieve" in {

    val map = new MyMap[String, String]()
    assert(map.isEmpty)
    map.put("k1", "v1")
    map.put("k2", "v2")

    assertResult(2){ map.size() }
    assert(map.get("k1").isDefined)
    assertResult("v1") { map.get("k1").get }

    map.put("k1", "v1-new")
    assert("v1-new" == map.get("k1").get)

  }

  it should "return none if key is not matched" in {

    val map = new MyMap[String, String]()
    assert(map.isEmpty)
    map.put("k1", "v1")
    map.put("k2", "v2")

    assert(map.get("k1").isDefined)
    assert(map.get("k3").isEmpty)

  }

  "Map " should " be able to remove elements using key " in {

    val map = new MyMap[String, String]()
    assert(map.isEmpty)
    map.put("k1", "v1")
    map.put("k2", "v2")

    assertResult(2){ map.size() }
    assert(map.remove("k1").isDefined)

    assertResult(1){ map.size() }
    assert(map.get("k1").isEmpty)

  }

  it should "handle keys with same hashcode" in {

    val map = new MyMap[DummyKey, String]()
    val key1: DummyKey = new DummyKey("K1")
    val key2: DummyKey = new DummyKey("K2")

    map.put(key1, "S1")
    map.put(key2, "S2")

    assertResult("S1") { map.get(key1).get }
    assertResult("S2") { map.get(key2).get }

  }


  it should "handle null keys" in {

    val map = new MyMap[String, String]()
    map.put(null, "NULL_VAL")
    assertResult("NULL_VAL") { map.get(null).get }

    map.put(null, "NEW_NULL_VAL")
    assertResult("NEW_NULL_VAL") { map.get(null).get }

  }

  it should "create iterator on entries " in {

    val map = new MyMap[String, String]()
    assert(map.isEmpty)
    map.put("k1", "v1")
    map.put("k2", "v2")

    val expectedKeys = List("k1", "k2")
    assertResult(2){ map.size() }
    map.iterator().foreach(e => {
      if(!expectedKeys.contains(e.key)) {
        fail(e.key + " key not found in the iterator ")
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
