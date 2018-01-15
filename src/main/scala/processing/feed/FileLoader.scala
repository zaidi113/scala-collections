package main.scala.processing.feed

import scala.io.Source

/**
 * Created by muhammadraza on 06/11/2016.
 */
class FileLoader {

  def load(path: String)  {

    val lines = Source.fromFile(path, "UTF-8").toList
    lines.foreach(println)
  }

  def parseLine(line: String): String = {
    line.toLowerCase
  }
}

object FileLoader {
  def loadFile(path: String) = new FileLoader().load(path)
}