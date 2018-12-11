package com.alxminyaev.eventlist.feature.feature.eventtable.data.datasource

import com.alxminyaev.eventlist.feature.feature.eventtable.domain.model.Event
import io.reactivex.Observer

interface EventTableDataSource {

    fun getEventsCards(observer: Observer<List<Event>>)

}
