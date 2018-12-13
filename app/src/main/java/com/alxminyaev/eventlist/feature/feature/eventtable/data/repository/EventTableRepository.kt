package com.alxminyaev.eventlist.feature.feature.eventtable.data.repository

import com.alxminyaev.eventlist.feature.feature.eventtable.domain.model.Event
import io.reactivex.Observable

interface EventTableRepository {

    fun loadEvents() : Observable<List<Event>>

}
