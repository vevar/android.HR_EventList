package com.alxminyaev.eventlist.feature.eventtable.domain

import com.alxminyaev.eventlist.feature.eventtable.data.repository.EventTableRepository
import com.alxminyaev.eventlist.feature.eventtable.domain.model.EventModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class EventTableInteractorImpl(private val repository: EventTableRepository) : EventTableInteractor {

    override fun loadEvents(observer: Observer<List<EventModel>>) {
        val single = repository.loadEventsFromRemote().toObservable()
        single.subscribe(object : Observer<List<EventModel>>{
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(list: List<EventModel>) {
                repository.saveAllToLocal(list)
                single.subscribe(observer)
            }

            override fun onError(e: Throwable) {
                repository.loadEventsFromLocal().toObservable().subscribe(observer)
            }


        })


    }


}