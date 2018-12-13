package com.alxminyaev.eventlist.feature.feature.eventtable.presentation

import com.alxminyaev.eventlist.feature.feature.MvpPresenter
import com.alxminyaev.eventlist.feature.feature.eventtable.domain.EventTableInteractor
import com.alxminyaev.eventlist.feature.feature.eventtable.domain.model.Event
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class EventTablePresenter(private val interactor: EventTableInteractor) : MvpPresenter<EventTableView>(),
    Observer<List<Event>> {

    private lateinit var loaderEventsDiposable : Disposable

    override fun onComplete() {
    }

    override fun onSubscribe(disposable: Disposable) {
        loaderEventsDiposable = disposable
    }

    override fun onNext(t: List<Event>) {
        view?.showEventTable(t)
        view?.hideProgressBar()
    }

    override fun onError(e: Throwable) {
        TODO("not implemented")
    }

    override fun onViewReady() {
        loadEventTable()
    }

    private fun loadEventTable() {
        view?.showProgressBar()
        interactor.loadEvents()
            .subscribe(this)

    }
}
