package com.alxminyaev.eventlist.feature.eventtable.data.datasource.remote.api

import com.alxminyaev.eventlist.feature.eventtable.data.datasource.remote.api.dto.TheEventCard
import io.reactivex.Single
import retrofit2.http.GET

interface EventTableApi {

    @GET("/api/v1/Events/registration")
    fun getEventTable(): Single<List<TheEventCard>>


}