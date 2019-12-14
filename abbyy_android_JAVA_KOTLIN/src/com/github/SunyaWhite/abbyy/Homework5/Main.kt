package com.github.SunyaWhite.abbyy.Homework5

fun main () {
    println("Hello world!")

    var someClass = SomeTestClass()

    println("someClass int before cahnge = ${someClass.propInt}")
    someClass.propInt = 30
    println("someClass int after change = ${someClass.propInt}")

    println("someClass long before cahnge = ${someClass.propLong}")
    someClass.propLong = 30000000L
    println("someClass long after change = ${someClass.propLong}")

    println("someClass char before cahnge = ${someClass.propChar}")
    someClass.propChar = 'b'
    println("someClass char after change = ${someClass.propChar}")

    println("someClass str before cahnge = ${someClass.propString}")
    someClass.propString = "def"
    println("someClass str after change = ${someClass.propString}")

    println("someClass double before cahnge = ${someClass.propDouble}")
    someClass.propDouble = 31.4
    println("someClass double after change = ${someClass.propDouble}")

    println("someClass str after change = ${someClass.propString}")

    println("someClass str after change = ${someClass.propString}")


}

