package com.alxminyaev.eventlist.feature.feature.eventtable.data.repository

import com.alxminyaev.eventlist.feature.feature.eventtable.domain.model.Event
import io.reactivex.Observer

interface EventTableRepository {

    fun loadEvents(observer:  Observer<List<Event>>)

}
