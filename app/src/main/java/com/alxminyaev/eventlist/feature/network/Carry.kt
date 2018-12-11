package com.alxminyaev.eventlist.feature.network

interface Carry<T> {

    fun onSuccess(result : T)

    fun onFailure(throwable: Throwable)
}