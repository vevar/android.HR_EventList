package com.alxminyaev.eventlist.feature.feature.eventtable.data

import com.alxminyaev.eventlist.feature.feature.eventtable.data.dto.TheEventCard
import io.reactivex.Observable
import retrofit2.http.GET

interface EventTableApi {

    @GET("/api/v1/Events/registration")
    fun getEventTable(): Observable<List<TheEventCard>>


}