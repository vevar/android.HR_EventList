package com.alxminyaev.eventlist.feature.feature.eventtable.data.repository

import com.alxminyaev.eventlist.feature.feature.eventtable.data.datasource.EventTableDataSource
import com.alxminyaev.eventlist.feature.feature.eventtable.domain.model.Event
import io.reactivex.Observer

class EventTableRepositoryImpl(private val dataSource: EventTableDataSource) : EventTableRepository {

    override fun loadEvents(observer: Observer<List<Event>>) {
        return dataSource.getEventsCards(observer)
    }

}
