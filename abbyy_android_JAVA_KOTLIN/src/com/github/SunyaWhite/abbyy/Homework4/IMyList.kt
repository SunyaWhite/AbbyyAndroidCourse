package com.github.SunyaWhite.abbyy.Homework4

interface IMyList<T> {

    fun get (index : Int) : T

    fun get () : T

    fun set (index : Int, newValue : T) : Unit

    fun insert (index : Int, newValue : T) : Unit

    fun add (newValue : T) : Unit

    fun delete (index : Int) : T

}