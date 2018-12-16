package com.alxminyaev.eventlist.feature.memberlist.presentation

import com.alxminyaev.eventlist.feature.MvpPresenter
import com.alxminyaev.eventlist.feature.memberlist.domain.MemberListInteractor

class MemberListPresenter(private val interactor: MemberListInteractor) : MvpPresenter<MemberListView>() {
    override fun onViewReady() {
        loadListMembers()
    }

    private fun loadListMembers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}