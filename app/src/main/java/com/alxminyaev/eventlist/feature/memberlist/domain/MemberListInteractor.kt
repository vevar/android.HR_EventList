package com.alxminyaev.eventlist.feature.memberlist.domain

import com.alxminyaev.eventlist.feature.memberlist.domain.model.MemberShort
import io.reactivex.Observable

interface MemberListInteractor {
    fun loadMember(eventId: Int): Observable<List<MemberShort>>
}
