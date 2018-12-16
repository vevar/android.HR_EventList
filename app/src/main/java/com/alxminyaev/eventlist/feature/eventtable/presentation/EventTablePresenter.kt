package com.alxminyaev.eventlist.feature.eventtable.presentation

import com.alxminyaev.eventlist.feature.MvpPresenter
import com.alxminyaev.eventlist.feature.eventtable.domain.EventTableInteractor
import io.reactivex.android.schedulers.AndroidSchedulers

class EventTablePresenter(private val interactor: EventTableInteractor) : MvpPresenter<EventTableView>() {

    override fun onViewReady() {
        loadEventTable()
    }

    private fun loadEventTable() {
        view?.showProgressBar()
        val disposable = interactor.loadEvents()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view?.showEventTable(it)
                view?.hideProgressBar()
            }


    }
}
