package com.alxminyaev.eventlist

import com.alxminyaev.eventlist.feature.network.Carry
import com.alxminyaev.eventlist.feature.network.Wrapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DefaultCallback<T>(private val carry: Carry<T>) : Callback<Wrapper<T>> {

    override fun onResponse(call: Call<Wrapper<T>>, response: Response<Wrapper<T>>) {
        val wrapper: Wrapper<T>? = response.body()
        if (wrapper != null) {
            carry.onSuccess(wrapper.getData())
        } else {
            TODO()
        }
    }

    override fun onFailure(call: Call<Wrapper<T>>, t: Throwable) {
        TODO("not implemented")
    }


}
