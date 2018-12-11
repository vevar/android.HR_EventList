package com.alxminyaev.eventlist.feature.feature.eventtable.presentation

import com.alxminyaev.eventlist.feature.feature.MvpView
import com.alxminyaev.eventlist.feature.feature.eventtable.domain.model.Event

interface EventTableView : MvpView {

    fun showProgressBar()

    fun hideProgressBar()

    fun showEventTable(result: List<Event>)

    fun showError()

    fun showError(throwable: Throwable)
}
