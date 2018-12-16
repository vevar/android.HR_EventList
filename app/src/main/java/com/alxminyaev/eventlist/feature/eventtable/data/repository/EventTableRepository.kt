package com.alxminyaev.eventlist.feature.eventtable.data.repository

import com.alxminyaev.eventlist.feature.eventtable.domain.model.EventModel
import io.reactivex.Observable
import io.reactivex.Single

interface EventTableRepository {

    fun loadEvents(): Observable<List<EventModel>>

}
