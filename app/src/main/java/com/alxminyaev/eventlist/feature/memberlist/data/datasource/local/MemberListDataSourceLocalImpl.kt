package com.alxminyaev.eventlist.feature.memberlist.data.datasource.local

import com.alxminyaev.eventlist.feature.memberlist.data.datasource.local.dao.MemberListDao
import com.alxminyaev.eventlist.feature.memberlist.data.datasource.remote.dto.TheMember
import io.reactivex.Observable
import io.reactivex.Single

class MemberListDataSourceLocalImpl(private val memberListDao: MemberListDao) : MemberListLocalDataSource {
    override fun getMemberList(eventId: Int): Single<List<TheMember>> {
        val list = listOf<TheMember>()
        return Observable.fromIterable(list).toList()
    }

}
