package com.home.utils

import java.io.File
import java.lang.Math._

import scala.io.{Source, StdIn}

/**
 * Created by muhammadraza on 14/02/2016.
 */
object TimesTable extends App{

  def writeTable(from: Int, to: Int) : Unit = {

    var num = from
    while(num <= to){
      for(i <- 1 to 10){
        println(num+"*"+i+"=" + multiply(i, num))
      }
      num += 1
    }

  }

  def printSum(num1: Int, num2: Int = 10) : Unit = {

    println("Adding "+num1+ " into "+num2 + " = " + num1.+(num2))

  }

  def numberGuess() = {

    var number = 0
    var magicNumber = (random() * 30).toInt
    println("Guess a Number")
    do{

      number = StdIn.readLine().toInt
      if(number > magicNumber ) println("number too high")
      else if(number < magicNumber) println("number too low")

    }while(number != magicNumber)

    println("Congratulations !!! Number was " +  magicNumber)
  }

  def squareRoot(num: Double): Double = {
      sqrt(num)
  }

  def multiply(num1: Int, num2: Int) : Int = {
      num1*num2
  }

  override def main(args: Array[String]): Unit ={

    forLoop()

  }

  def forLoop() {

    val filesHere = (new java.io.File("/Users/muhammadraza/downloads")).listFiles

    for( f  <- filesHere
         if f.isFile
         if f.getName.endsWith("txt");
          line <- getLines(f) if line contains "JIDE"


    ){
      println(f.getAbsolutePath + ">>> " + line)
    }
  }

  def getLines(f: File): List[String] ={
    Source.fromFile(f).getLines().toList

  }

}