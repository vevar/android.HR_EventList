package com.alxminyaev.eventlist.feature.memberlist.data.datasource.remote

import com.alxminyaev.eventlist.feature.memberlist.data.datasource.remote.api.MemberListApi
import com.alxminyaev.eventlist.feature.memberlist.data.datasource.remote.dto.TheMember
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class MemberListRemoteDataSourceImpl(private val api: MemberListApi) : MemberListRemoteDataSource {

    override fun getMemberListByEventId(eventId: Int): Single<List<TheMember>> {
        return api.getMemberListByEventId(eventId)
            .subscribeOn(Schedulers.io())
    }

}