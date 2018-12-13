package com.alxminyaev.eventlist.feature.eventtable.data.datasource

import com.alxminyaev.eventlist.feature.eventtable.data.datasource.api.EventTableApi
import com.alxminyaev.eventlist.feature.eventtable.data.dto.TheEventCard
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EventTableDataSourceRemoteImpl(private val api: EventTableApi) : EventTableDataSource {

    override fun getEventsCards(): Observable<List<TheEventCard>> {
        return api.getEventTable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }



}
