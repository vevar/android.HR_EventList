package com.alxminyaev.eventlist.feature.eventtable.data.datasource.api

import com.alxminyaev.eventlist.feature.eventtable.data.datasource.api.dto.TheEventCard
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface EventTableApi {

    @GET("/api/v1/Events/registration")
    fun getEventTable(): Single<List<TheEventCard>>


}