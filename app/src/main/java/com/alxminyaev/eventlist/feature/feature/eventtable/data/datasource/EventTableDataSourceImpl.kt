package com.alxminyaev.eventlist.feature.feature.eventtable.data.datasource

import com.alxminyaev.eventlist.feature.feature.eventtable.data.ConverterDTO
import com.alxminyaev.eventlist.feature.feature.eventtable.data.EventTableApi
import com.alxminyaev.eventlist.feature.feature.eventtable.domain.model.Event
import io.reactivex.Observer
import io.reactivex.schedulers.Schedulers

class EventTableDataSourceImpl(private val api: EventTableApi) : EventTableDataSource {
    override fun getEventsCards(observer: Observer<List<Event>>) {
        api.getEventTable().map { list ->
            list.map {
                ConverterDTO.convertToEvent(it)
            }
        }.subscribeOn(Schedulers.io())
            .subscribe(observer)
    }


}
