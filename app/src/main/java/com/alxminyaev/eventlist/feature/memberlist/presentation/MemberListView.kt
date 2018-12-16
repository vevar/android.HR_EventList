package com.alxminyaev.eventlist.feature.memberlist.presentation

import com.alxminyaev.eventlist.feature.MvpView
import com.alxminyaev.eventlist.feature.memberlist.domain.model.MemberShort

interface MemberListView : MvpView {
    fun showProgressBar()

    fun hideProgressBar()

    fun showMemberList(memberList: List<MemberShort>)

    fun showError()

    fun showError(throwable: Throwable)
}
