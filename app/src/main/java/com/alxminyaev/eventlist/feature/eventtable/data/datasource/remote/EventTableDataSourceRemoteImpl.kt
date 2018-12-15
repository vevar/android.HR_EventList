package com.alxminyaev.eventlist.feature.eventtable.data.datasource.remote

import com.alxminyaev.eventlist.feature.eventtable.data.datasource.remote.api.EventTableApi
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.remote.api.dto.TheEventCard
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EventTableDataSourceRemoteImpl(private val api: EventTableApi) :
    EventTableRemoteDataSource {

    override fun getEventsCards(): Single<List<TheEventCard>> {
        return api.getEventTable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
