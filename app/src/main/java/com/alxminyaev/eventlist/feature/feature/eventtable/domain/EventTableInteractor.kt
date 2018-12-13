package com.alxminyaev.eventlist.feature.feature.eventtable.domain

import com.alxminyaev.eventlist.feature.feature.eventtable.domain.model.Event
import io.reactivex.Observable
import io.reactivex.Observer

interface EventTableInteractor {

    fun loadEvents(): Observable<List<Event>>


}
