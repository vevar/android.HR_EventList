package com.alxminyaev.eventlist.feature.eventtable.data.datasource.local

import com.alxminyaev.eventlist.feature.eventtable.data.datasource.remote.api.dto.TheEventCard
import io.reactivex.Single

interface EventTableLocalDataSource {

    fun getEventsCards(): Single<List<TheEventCard>>

    fun saveAll(list: List<TheEventCard>): Single<List<TheEventCard>>
}
