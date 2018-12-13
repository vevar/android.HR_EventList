package com.alxminyaev.eventlist.network

interface Carry<T> {

    fun onSuccess(result : T)

    fun onFailure(throwable: Throwable)
}