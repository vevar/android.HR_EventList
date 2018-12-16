package com.alxminyaev.eventlist.feature.memberlist.data.datasource.local

import com.alxminyaev.eventlist.feature.memberlist.data.datasource.remote.dto.TheMember
import io.reactivex.Single

interface MemberListLocalDataSource {
    fun getMemberList(eventId : Int) : Single<List<TheMember>>
}
