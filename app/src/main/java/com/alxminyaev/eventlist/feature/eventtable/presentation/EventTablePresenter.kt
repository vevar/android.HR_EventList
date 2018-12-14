package com.alxminyaev.eventlist.feature.eventtable.presentation

import com.alxminyaev.eventlist.feature.MvpPresenter
import com.alxminyaev.eventlist.feature.eventtable.domain.EventTableInteractor
import com.alxminyaev.eventlist.feature.eventtable.domain.model.EventModel
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class EventTablePresenter(private val interactor: EventTableInteractor) : MvpPresenter<EventTableView>(),
    Observer<List<EventModel>> {
    override fun onComplete() {
        loaderEventsDisposable.dispose()
    }

    override fun onNext(t: List<EventModel>) {
        view?.showEventTable(t)
        view?.hideProgressBar()
    }

    private lateinit var loaderEventsDisposable: Disposable

    override fun onSubscribe(disposable: Disposable) {
        loaderEventsDisposable = disposable
    }


    override fun onError(e: Throwable) {
        TODO("not implemented")
    }

    override fun onViewReady() {
        loadEventTable()
    }

    private fun loadEventTable() {
        view?.showProgressBar()
        interactor.loadEvents(this)


    }
}
