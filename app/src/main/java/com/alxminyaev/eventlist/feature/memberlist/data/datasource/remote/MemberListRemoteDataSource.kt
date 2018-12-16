package com.alxminyaev.eventlist.feature.memberlist.data.datasource.remote

import com.alxminyaev.eventlist.feature.memberlist.data.datasource.remote.dto.TheMember
import io.reactivex.Single

interface MemberListRemoteDataSource {

    fun getMemberListByEventId(eventId: Int): Single<List<TheMember>>
}
