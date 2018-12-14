package com.alxminyaev.eventlist.feature.eventtable.data.datasource

import com.alxminyaev.eventlist.feature.eventtable.data.datasource.api.dto.TheEventCard
import io.reactivex.Single

interface EventTableDataSource {

    fun getEventsCards(): Single<List<TheEventCard>>

    fun saveAll(single: Single<List<TheEventCard>>)
}
