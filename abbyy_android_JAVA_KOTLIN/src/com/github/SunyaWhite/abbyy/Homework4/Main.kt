package com.github.SunyaWhite.abbyy.Homework4

import java.lang.Exception

fun main() {
    println("Hello, world!")
    var myList : MyArrayList<Int> = MyArrayList(2)
    myList.display()
    try {
        // getting empty array
        println(myList.get(0))
    }
    catch (exc : Exception) {
        // an exception must occur
        println(exc)
    }
    myList.add(1)
    myList.display()
    myList.insert(1, 2)
    myList.display()
    println(" count : ${myList.count}")
    myList.add(3)
    myList.display()
    println(" count : ${myList.count}")
    myList.insert(1, 4)
    myList.display()
    myList.insert(4, 5)
    myList.display()
    myList.delete(0)
    myList.display()
    myList.add(6)
    myList.display()
    println(myList.get())
    println(myList.get(0))
    try {
        //getting element at position out of bounds
        println(myList.get(myList.count))
    }
    catch (exc : Exception) {
        // an exception must occur
        println(exc)
    }
    myList.delete(myList.count - 1)
    myList.display()
    println(" count : ${myList.count}")
}
