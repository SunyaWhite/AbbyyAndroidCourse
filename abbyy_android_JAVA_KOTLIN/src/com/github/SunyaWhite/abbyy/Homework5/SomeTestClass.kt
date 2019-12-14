package com.github.SunyaWhite.abbyy.Homework5

class SomeTestClass {

    public var propInt : Int by StorageDelegate<Int>("int", 20)

    public var propLong : Long by StorageDelegate<Long>("long", 200000000L)

    public var propChar : Char by StorageDelegate<Char>("char", 'a')

    public var propString : String by StorageDelegate<String>("str", "abc")

    public var propDouble : Double by StorageDelegate<Double>("double", 3.14)

}