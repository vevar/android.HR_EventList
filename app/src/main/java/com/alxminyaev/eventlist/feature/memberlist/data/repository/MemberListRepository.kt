package com.alxminyaev.eventlist.feature.memberlist.data.repository

import com.alxminyaev.eventlist.feature.memberlist.domain.model.MemberShort
import io.reactivex.Observable

interface MemberListRepository {
    fun loadMemberList(eventId: Int): Observable<List<MemberShort>>
}
