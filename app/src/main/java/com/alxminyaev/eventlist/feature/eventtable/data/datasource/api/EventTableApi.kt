package com.alxminyaev.eventlist.feature.eventtable.data.datasource.api

import com.alxminyaev.eventlist.feature.eventtable.data.dto.TheEventCard
import io.reactivex.Observable
import retrofit2.http.GET

interface EventTableApi {

    @GET("/api/v1/Events/registration")
    fun getEventTable(): Observable<List<TheEventCard>>


}