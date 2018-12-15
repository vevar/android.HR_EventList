package com.alxminyaev.eventlist.feature.memberlist.data.repository

import com.alxminyaev.eventlist.feature.memberlist.data.datasource.local.MemberListLocalDataSource
import com.alxminyaev.eventlist.feature.memberlist.data.datasource.remote.MemberListRemoteDataSource

class MemberListRepositoryImpl(
    private val dataSourceRemote: MemberListRemoteDataSource,
    private val dataSourceLocal: MemberListLocalDataSource
) : MemberListRepository {

}
