package com.alxminyaev.eventlist.feature.eventtable.data.datasource

import com.alxminyaev.eventlist.feature.eventtable.data.dto.TheEventCard
import io.reactivex.Observable

interface EventTableDataSource {

    fun getEventsCards(): Observable<List<TheEventCard>>

}
