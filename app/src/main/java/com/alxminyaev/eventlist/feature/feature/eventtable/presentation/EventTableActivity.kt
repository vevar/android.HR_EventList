package com.alxminyaev.eventlist.feature.feature.eventtable.presentation

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.ProgressBar
import com.alxminyaev.eventlist.R
import com.alxminyaev.eventlist.feature.feature.BaseActivity
import com.alxminyaev.eventlist.feature.feature.MvpPresenter
import com.alxminyaev.eventlist.feature.feature.eventtable.domain.model.Event

class EventTableActivity : BaseActivity<EventTableView>(), EventTableView {

    private lateinit var recyclerViewAdapter: EventTableAdapter
    private lateinit var recycleView: RecyclerView
    private lateinit var progressBar: ProgressBar

    private lateinit var presenter: EventTablePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_table)

        initView()
    }

    private fun initView() {
        progressBar = findViewById(R.id.event_progress)
        recycleView = findViewById(R.id.event_recycle_view)

        recyclerViewAdapter = EventTableAdapter(this)
        recycleView.adapter = recyclerViewAdapter
    }

    override fun getPresenter(): MvpPresenter<EventTableView> {
        presenter = PresenterFactory.createPresenter(this)
        return presenter
    }

    override fun getMvpView(): EventTableView {
        return this
    }

    override fun showProgressBar() {
        progressBar.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = ProgressBar.GONE
    }

    override fun showEventTable(result: List<Event>) {
        recyclerViewAdapter.setListEvents(result)
    }

    override fun showError() {
        TODO("not implemented")
    }

    override fun showError(throwable: Throwable) {
        TODO("not implemented")
    }
}
