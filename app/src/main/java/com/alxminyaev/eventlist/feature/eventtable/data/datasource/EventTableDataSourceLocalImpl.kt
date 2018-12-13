package com.alxminyaev.eventlist.feature.eventtable.data.datasource

import com.alxminyaev.eventlist.feature.eventtable.data.dto.TheEventCard
import io.reactivex.Observable

class EventTableDataSourceLocalImpl : EventTableDataSource {

    override fun getEventsCards(): Observable<List<TheEventCard>> {
        TODO()
    }
}