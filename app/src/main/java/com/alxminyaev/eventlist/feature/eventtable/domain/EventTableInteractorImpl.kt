package com.alxminyaev.eventlist.feature.eventtable.domain

import com.alxminyaev.eventlist.feature.eventtable.data.repository.EventTableRepository
import com.alxminyaev.eventlist.feature.eventtable.domain.model.EventModel
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class EventTableInteractorImpl(private val repository: EventTableRepository) : EventTableInteractor {

    override fun loadEvents(): Observable<List<EventModel>> {
        return repository.loadEvents()
    }


}