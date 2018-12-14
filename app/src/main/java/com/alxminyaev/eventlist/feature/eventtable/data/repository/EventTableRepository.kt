package com.alxminyaev.eventlist.feature.eventtable.data.repository

import com.alxminyaev.eventlist.feature.eventtable.domain.model.EventModel
import io.reactivex.Single

interface EventTableRepository {

    fun loadEventsFromRemote(): Single<List<EventModel>>

    fun loadEventsFromLocal(): Single<List<EventModel>>

    fun saveAllToLocal(list: List<EventModel>)
}
