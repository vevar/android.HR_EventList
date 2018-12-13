package com.alxminyaev.eventlist.feature.feature.eventtable.domain

import com.alxminyaev.eventlist.feature.feature.eventtable.data.repository.EventTableRepository
import com.alxminyaev.eventlist.feature.feature.eventtable.domain.model.Event
import io.reactivex.Observable

class EventTableInteractorImpl(private val repository: EventTableRepository) : EventTableInteractor {

    override fun loadEvents(): Observable<List<Event>> {
        return repository.loadEvents()
    }

}