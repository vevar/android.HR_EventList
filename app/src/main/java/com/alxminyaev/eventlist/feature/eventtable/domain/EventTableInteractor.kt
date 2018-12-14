package com.alxminyaev.eventlist.feature.eventtable.domain

import com.alxminyaev.eventlist.feature.eventtable.domain.model.EventModel
import io.reactivex.Observer

interface EventTableInteractor {

    fun loadEvents(observer: Observer<List<EventModel>>)


}
