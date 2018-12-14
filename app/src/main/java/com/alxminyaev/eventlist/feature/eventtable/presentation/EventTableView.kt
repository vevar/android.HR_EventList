package com.alxminyaev.eventlist.feature.eventtable.presentation

import com.alxminyaev.eventlist.feature.MvpView
import com.alxminyaev.eventlist.feature.eventtable.domain.model.EventModel

interface EventTableView : MvpView {

    fun showProgressBar()

    fun hideProgressBar()

    fun showEventTable(result: List<EventModel>)

    fun showError()

    fun showError(throwable: Throwable)
}
