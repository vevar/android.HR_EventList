package com.alxminyaev.eventlist.feature.memberlist.presentation

import android.support.v7.widget.RecyclerView
import android.widget.Adapter
import android.widget.ProgressBar
import com.alxminyaev.eventlist.feature.BaseActivity
import com.alxminyaev.eventlist.feature.MvpPresenter

class MemberListActivity : BaseActivity<MemberListView>(), MemberListView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: MemberListAdapter
    private lateinit var progressBar: ProgressBar

    private lateinit var presenter: MemberListPresenter

    override fun getPresenter(): MvpPresenter<MemberListView> {
        presenter = MemberListPresenterFactory.createPresenter(this)
        return presenter
    }

    override fun getMvpView(): MemberListView {
        return this
    }
}