package com.alxminyaev.eventlist

import android.app.Application
import android.content.Context
import com.alxminyaev.eventlist.feature.network.RetrofitProvider

class App : Application() {

    private lateinit var retrofitProvider: RetrofitProvider

    companion object {
        private fun getApp(context: Context): App {
            return context.applicationContext as App
        }

        fun getRetrofitProvider(context: Context): RetrofitProvider {
            return getApp(context).retrofitProvider
        }
    }

    override fun onCreate() {
        super.onCreate()
        retrofitProvider = RetrofitProvider()
    }


}