package com.alxminyaev.eventlist.feature.eventtable.presentation

import com.alxminyaev.eventlist.feature.MvpPresenter
import com.alxminyaev.eventlist.feature.eventtable.domain.EventTableInteractor
import com.alxminyaev.eventlist.feature.eventtable.domain.model.EventModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class EventTablePresenter(private val interactor: EventTableInteractor) : MvpPresenter<EventTableView>(),
    Observer<List<EventModel>> {

    private lateinit var loaderEventsDisposable: Disposable

    override fun onComplete() {
        loaderEventsDisposable.dispose()
    }

    override fun onNext(t: List<EventModel>) {
        view?.showEventTable(t)
        view?.hideProgressBar()
    }


    override fun onSubscribe(disposable: Disposable) {
        loaderEventsDisposable = disposable
    }


    override fun onError(e: Throwable) {
    }

    override fun onViewReady() {
        loadEventTable()
    }

    private fun loadEventTable() {
        view?.showProgressBar()
        val dsi = interactor.loadEvents()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({}, {})



    }
}
