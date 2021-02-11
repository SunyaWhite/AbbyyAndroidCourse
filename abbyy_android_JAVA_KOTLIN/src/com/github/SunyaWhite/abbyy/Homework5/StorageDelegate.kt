package com.github.SunyaWhite.abbyy.Homework5

import kotlin.reflect.KProperty
import java.lang.IllegalArgumentException

class StorageDelegate<T>(key:String, initValue : T) {
    //private val _storage : IStorage
    private val key : String

    private companion object _storage : Storage()

    init {
        //this._storage = Storage()
        this.key = key
        if(!_storage.containsKey(key))
            putValue<T>(this.key, initValue)
    }

    private fun <T> putValue(key : String, value : T) =
            when(value)
            {
                is Int -> _storage.put(key, value)
                is Long -> _storage.put(key, value)
                is Char -> _storage.put(key, value)
                is String -> _storage.put(key, value)
                is Double -> _storage.put(key, value)
                else -> throw IllegalArgumentException()
            }

    public operator fun getValue(thisRef: Any?, property: KProperty<*>) : T = _storage.get(key) as T

    public operator fun setValue (thisRef : Any?, property: KProperty<*>, value : T) = putValue(key, value)
}