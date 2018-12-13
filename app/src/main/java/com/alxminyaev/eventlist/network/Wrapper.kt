package com.alxminyaev.eventlist.network

class Wrapper<T>(private val data : T) {

    private val status: String? = null
    private val message: String? = null

    fun getStatus(): String? {
        return status
    }

    fun getMessage(): String? {
        return message
    }

    fun getData(): T {
        return data
    }
}
