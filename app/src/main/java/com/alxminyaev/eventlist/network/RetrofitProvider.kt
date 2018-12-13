package com.alxminyaev.eventlist.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {

    companion object {
        private const val BASE_URL = "https://beta-team.cft.ru/"
    }

    private var retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun createClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        builder.addInterceptor(logInterceptor)

        return builder.build()
    }

    fun getRetrofit(): Retrofit {
        return retrofit
    }
}