package com.alxminyaev.eventlist.feature.eventtable.domain

import com.alxminyaev.eventlist.feature.eventtable.data.repository.EventTableRepository
import com.alxminyaev.eventlist.feature.eventtable.domain.model.EventModel
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class EventTableInteractorImpl(private val repository: EventTableRepository) : EventTableInteractor {

    override fun loadEvents(observer: Observer<List<EventModel>>) {
        val observable = repository.loadEventsFromRemote().toObservable()
        observable.subscribe(object : Observer<List<EventModel>>{
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(list: List<EventModel>) {
                val observableEvents = Observable.fromIterable(list).toList()
                repository.saveAllToLocal(observableEvents)
                observable.subscribe(observer)
            }

            override fun onError(e: Throwable) {
                repository.loadEventsFromLocal().toObservable().subscribe(observer)
            }


        })


    }


}