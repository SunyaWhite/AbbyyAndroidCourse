package com.github.SunyaWhite.abbyy.Homework4

class MyArrayList<T>(initialCapacity : Int = 10) : IMyList<T>{

    /*
    Our storage
     */
    private var _values : Array<Any?> = Array(initialCapacity) {_ -> null}

    /*
    Number of elements in the storage
     */
    var count : Int = 0
        public get
        private set

    /*
    Display all values of the storage (nulls are included)
     */
    fun display() {
        _values.forEach { any -> print("${any} ") }
        println()
    }

    /*
    Extend the size of the _values
     */
    private fun extendSize() : Unit {
        _values = _values.copyOf(_values.size * 2) // side effect function
    }

    /*
    Get the element at position index
    If the count of elements will be less or equal than the index or index is less than 0,
     ArrayIndexOutOfBoundsException is thrown
     */
    override fun get(index: Int): T =
            if (count <= index || index < 0) throw ArrayIndexOutOfBoundsException() else _values[index] as T

    /*
    Get the last element
    If the storage is empty , ArrayIndexOutOfBoundsException is thrown
    */
    override fun get(): T =
            if (count < 1 ) throw ArrayIndexOutOfBoundsException() else _values[count - 1] as T

    /*
    Set the element at index position
    If  the count of elements will be less or equal than the index or index is less than 0 ,
     ArrayIndexOutOfBoundsException is thrown
     */
    override fun set(index: Int, newValue: T) {
        if (count <= index || index < 0) throw ArrayIndexOutOfBoundsException()
        _values[index] = newValue
    }

    /*
    Insert value at specific index position
    If the count of elements will be less than the index or index is less than 0 ,
    ArrayIndexOutOfBoundsException is thrown
     */
    override fun insert(index: Int, newValue: T) {
        if (count < index || index < 0) throw ArrayIndexOutOfBoundsException()
        if(count + 1> _values.size) extendSize()
        var prev : Any? = null
        // function fold with a side effect to _values
        _values.fold(0){acc, any ->
            if(acc == index)
                prev = _values[acc]
            else if (acc > index) {
                val temp = _values[acc]
                _values[acc] = prev
                prev = temp
            }
            acc + 1
        }
        _values[index] = newValue
        count++
    }

    /*
    Add new value to the storage at the last position
     */
    override fun add(newValue: T) {
        if(count >= _values.size ) extendSize()
        _values[count++] = newValue
    }

    /*
    Delete value at specific index position
    If  the count of elements will be less than the index or index is less than 0 ,
    ArrayIndexOutOfBoundsException is thrown
    Return the deleted value
     */
    override fun delete(index: Int): T {
        if (count < index || index < 0) throw ArrayIndexOutOfBoundsException()
        var res : T? = null
        _values.fold(0){acc, any ->
            if(acc == index)
                res = _values[acc] as T
            else if (acc > index)
                _values[acc-1] = _values[acc]
            acc + 1
        }
        _values[--count] = null
        return res!!
    }

}
