package com.alxminyaev.eventlist.feature.memberlist.domain

import com.alxminyaev.eventlist.feature.memberlist.data.repository.MemberListRepository
import com.alxminyaev.eventlist.feature.memberlist.domain.model.MemberShort
import io.reactivex.Observable

class MemberListInteractorImpl(private val repository: MemberListRepository) : MemberListInteractor {
    override fun loadMember(eventId: Int): Observable<List<MemberShort>> {
        return repository.loadMemberList(eventId)
    }


}
