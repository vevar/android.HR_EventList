package com.alxminyaev.eventlist.feature.memberlist.presentation

import com.alxminyaev.eventlist.feature.BaseActivity
import com.alxminyaev.eventlist.feature.MvpPresenter

class MemberListActivity : BaseActivity<MemberListView>(), MemberListView {


    private lateinit var presenter: MemberListPresenter

    override fun getPresenter(): MvpPresenter<MemberListView> {
        TODO("not implemented")
    }

    override fun getMvpView(): MemberListView {
        return this
    }
}