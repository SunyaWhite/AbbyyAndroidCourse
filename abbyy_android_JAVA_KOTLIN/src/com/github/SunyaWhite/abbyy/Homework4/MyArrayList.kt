package com.github.SunyaWhite.abbyy.Homework4

class MyArrayList<T>(initialCapacity : Int = 10) : IMyList<T>{

    /*
    Our storage
     */
    private var values : Array<Any?> = Array(initialCapacity) {_ -> null}

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
        values.forEach { any -> print("${any} ") }
        println()
    }

    /*
    Extend the size of the values
     */
    private fun extendSize() : Unit {
        values = values.copyOf(values.size * 2) // side effect function
    }

    /*
    Get the element at position index
    If the count of elements will be less or equal than the index or index is less than 0,
     ArrayIndexOutOfBoundsException is thrown
     */
    override fun get(index: Int): T =
            if (count <= index || index < 0) throw ArrayIndexOutOfBoundsException()
            else values[index] as T

    /*
    Get the last element
    If the storage is empty , ArrayIndexOutOfBoundsException is thrown
    */
    override fun get(): T =
            if (count < 1 ) throw ArrayIndexOutOfBoundsException()
            else values[count - 1] as T

    /*
    Set the element at index position
    If  the count of elements will be less or equal than the index or index is less than 0 ,
     ArrayIndexOutOfBoundsException is thrown
     */
    override fun set(index: Int, newValue: T) {
        if (count <= index || index < 0) throw ArrayIndexOutOfBoundsException()
        values[index] = newValue
    }

    /*
    Insert value at specific index position
    If the count of elements will be less than the index or index is less than 0 ,
    ArrayIndexOutOfBoundsException is thrown
     */
    override fun insert(index: Int, newValue: T) {
        if (count < index || index < 0) throw ArrayIndexOutOfBoundsException()
        if(count + 1> values.size) extendSize()
        var prev : Any? = null
        // function fold with a side effect to values
        values.fold(0){acc, any ->
            if(acc == index)
                prev = values[acc]
            else if (acc > index) {
                val temp = values[acc]
                values[acc] = prev
                prev = temp
            }
            acc + 1
        }
        values[index] = newValue
        count++
    }

    /*
    Add new value to the storage at the last position
     */
    override fun add(newValue: T) {
        if(count >= values.size ) extendSize()
        values[count++] = newValue
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
        values.fold(0){acc, any ->
            if(acc == index)
                res = values[acc] as T
            else if (acc > index)
                values[acc-1] = values[acc]
            acc + 1
        }
        values[--count] = null
        return res!!
    }

}
