package com.alxminyaev.eventlist.feature.memberlist.data.repository

import com.alxminyaev.eventlist.feature.memberlist.data.datasource.local.MemberListLocalDataSource
import com.alxminyaev.eventlist.feature.memberlist.data.datasource.remote.MemberListRemoteDataSource
import com.alxminyaev.eventlist.feature.memberlist.data.datasource.remote.dto.TheMember
import com.alxminyaev.eventlist.feature.memberlist.domain.model.MemberShort
import io.reactivex.Observable
import io.reactivex.Single

class MemberListRepositoryImpl(
    private val dataSourceRemote: MemberListRemoteDataSource,
    private val dataSourceLocal: MemberListLocalDataSource
) : MemberListRepository {

    override fun loadMemberList(eventId: Int): Observable<List<MemberShort>> {
        return dataSourceLocal.getMemberList(eventId)
            .mergeWith(getFromRemote(eventId))
            .map { list ->
                list.map {
                    convertMember(it)
                }
            }.toObservable()
    }

    private fun convertMember(member: TheMember): MemberShort {
        return MemberShort(
            member.id,
            member.lastName,
            member.firstName
        )
    }

    private fun getFromRemote(eventId: Int): Single<List<TheMember>> {
        return dataSourceRemote.getMemberListByEventId(eventId)
    }

}
