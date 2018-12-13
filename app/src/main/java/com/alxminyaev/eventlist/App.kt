package com.alxminyaev.eventlist

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.alxminyaev.eventlist.database.AppDataBase
import com.alxminyaev.eventlist.network.RetrofitProvider

class App : Application() {

    private lateinit var retrofitProvider: RetrofitProvider

    private lateinit var dataBase: AppDataBase

    companion object {
        private fun getApp(context: Context): App {
            return context.applicationContext as App
        }

        fun getRetrofitProvider(context: Context): RetrofitProvider {
            return getApp(context).retrofitProvider
        }

        fun getAppDataBase(context: Context): AppDataBase {
            return getApp(context).dataBase
        }

    }

    override fun onCreate() {
        super.onCreate()
        retrofitProvider = RetrofitProvider()

        dataBase = Room.databaseBuilder(
            getApp(this),
            AppDataBase::class.java,
            AppDataBase.DATABASE_NAME
        ).build()
    }
}