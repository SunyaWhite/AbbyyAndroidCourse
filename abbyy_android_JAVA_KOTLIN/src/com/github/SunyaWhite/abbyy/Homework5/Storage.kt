package com.github.SunyaWhite.abbyy.Homework5

import kotlin.collections.*

open class Storage : IStorage {
    private val map: MutableMap<String, Any?> = mutableMapOf<String, Any?>()

    private fun putIntoMap(key: String, value: Any?) : Unit { map[key] = value }

    override fun put(key: String, value: String): Unit = putIntoMap(key, value)

    override fun put(key: String, value: Int): Unit = putIntoMap(key, value)

    override fun put(key: String, value: Long): Unit = putIntoMap(key, value)

    override fun put(key: String, value: Char): Unit = putIntoMap(key, value)

    override fun put(key: String, value: Double): Unit = putIntoMap(key, value)

    override fun get(key: String): Any? = map[key]

    override fun containsKey(key: String): Boolean = map.containsKey(key)

}