package com.alxminyaev.eventlist.feature.eventtable.data.repository

import com.alxminyaev.eventlist.feature.eventtable.domain.model.Event
import io.reactivex.Observable

interface EventTableRepository {

    fun loadEventsFromRemote() : Observable<List<Event>>

}
