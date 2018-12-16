package com.alxminyaev.eventlist.feature.memberlist.presentation

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import com.alxminyaev.eventlist.R
import com.alxminyaev.eventlist.feature.BaseActivity
import com.alxminyaev.eventlist.feature.MvpPresenter
import com.alxminyaev.eventlist.feature.eventtable.presentation.EventTableView
import com.alxminyaev.eventlist.feature.memberlist.domain.model.MemberShort

class MemberListActivity : BaseActivity<MemberListView>(), MemberListView {

    private var eventId: Int = -1
    private var eventTitle: String = ""

    private lateinit var toolbar: Toolbar
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: MemberListAdapter
    private lateinit var progressBar: ProgressBar

    private lateinit var presenter: MemberListPresenter

    companion object {

        private const val EXTRA_EVENT_ID: String = "com.alxminyaev.eventlist.feature.memberlist.presentation_event_id"
        private const val EXTRA_EVENT_TITLE: String =
            "com.alxminyaev.eventlist.feature.memberlist.presentation_event_title"

        fun startMemberListActivity(activity: BaseActivity<EventTableView>, eventId: Int, eventTitle: String) {
            val intentToStartActivity = Intent(activity, MemberListActivity::class.java)
            intentToStartActivity.putExtra(EXTRA_EVENT_ID, eventId)
            intentToStartActivity.putExtra(EXTRA_EVENT_TITLE, eventTitle)
            activity.startActivity(intentToStartActivity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_list)

        initViewModel()
        initView()
    }


    override fun onStart() {
        super.onStart()

        presenter.loadListMembers(eventId)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val itemId = item?.itemId
        if (itemId != null) {
            when (itemId) {
                R.id.statistic -> showStatistic()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showStatistic() {
    }

    private fun initViewModel() {
        eventId = intent.getIntExtra(EXTRA_EVENT_ID, -1)
        eventTitle = intent.getStringExtra(EXTRA_EVENT_TITLE)
    }

    private fun initView() {

        toolbar = findViewById(R.id.toolbar)
        toolbar.title = eventTitle
        setSupportActionBar(toolbar)

        progressBar = findViewById(R.id.member_list_progress)
        recyclerView = findViewById(R.id.member_list_recycle_view)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = MemberListAdapter(this)
        recyclerView.adapter = recyclerViewAdapter
    }

    override fun getPresenter(): MvpPresenter<MemberListView> {
        presenter = MemberListPresenterFactory.createPresenter(this)
        return presenter
    }

    override fun getMvpView(): MemberListView {
        return this
    }

    override fun showProgressBar() {
        progressBar.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = ProgressBar.GONE
    }

    override fun showMemberList(memberList: List<MemberShort>) {
        recyclerViewAdapter.setMemberList(memberList)
    }

    override fun showError() {
        TODO("not implemented")
    }

    override fun showError(throwable: Throwable) {
        TODO("not implemented")
    }
}