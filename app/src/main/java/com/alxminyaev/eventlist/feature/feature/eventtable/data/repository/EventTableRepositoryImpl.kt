package com.alxminyaev.eventlist.feature.feature.eventtable.data.repository

import com.alxminyaev.eventlist.feature.feature.eventtable.data.ConverterDTO
import com.alxminyaev.eventlist.feature.feature.eventtable.data.datasource.EventTableDataSource
import com.alxminyaev.eventlist.feature.feature.eventtable.domain.model.Event
import io.reactivex.Observable

class EventTableRepositoryImpl(private val dataSource: EventTableDataSource) : EventTableRepository {

    override fun loadEvents(): Observable<List<Event>> {

        return dataSource.getEventsCards().map { list ->
            list.map {
                ConverterDTO.convertToEvent(it)
            }
        }

    }

}
