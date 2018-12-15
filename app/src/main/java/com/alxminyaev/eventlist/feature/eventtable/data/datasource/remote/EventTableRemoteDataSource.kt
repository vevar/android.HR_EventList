package com.alxminyaev.eventlist.feature.eventtable.data.datasource.remote

import com.alxminyaev.eventlist.feature.eventtable.data.datasource.remote.api.dto.TheEventCard
import io.reactivex.Single

interface EventTableRemoteDataSource {
    fun getEventsCards(): Single<List<TheEventCard>>

}