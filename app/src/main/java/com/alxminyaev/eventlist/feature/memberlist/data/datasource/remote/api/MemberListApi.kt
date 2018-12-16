package com.alxminyaev.eventlist.feature.memberlist.data.datasource.remote.api

import com.alxminyaev.eventlist.feature.memberlist.data.datasource.remote.dto.TheMember
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface MemberListApi {
    @GET("/api/v1/Registration/members/event/{eventId}?token=cftteamtest2018")
    fun getMemberListByEventId(@Path("eventId") eventId: Int): Single<List<TheMember>>
}
