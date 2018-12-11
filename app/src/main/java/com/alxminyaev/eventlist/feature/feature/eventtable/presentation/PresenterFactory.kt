package com.alxminyaev.eventlist.feature.feature.eventtable.presentation

import android.content.Context
import com.alxminyaev.eventlist.App
import com.alxminyaev.eventlist.feature.feature.eventtable.data.*
import com.alxminyaev.eventlist.feature.feature.eventtable.data.datasource.EventTableDataSource
import com.alxminyaev.eventlist.feature.feature.eventtable.data.datasource.EventTableDataSourceImpl
import com.alxminyaev.eventlist.feature.feature.eventtable.data.repository.EventTableRepository
import com.alxminyaev.eventlist.feature.feature.eventtable.data.repository.EventTableRepositoryImpl
import com.alxminyaev.eventlist.feature.feature.eventtable.domain.EventTableInteractor
import com.alxminyaev.eventlist.feature.feature.eventtable.domain.EventTableInteractorImpl

class PresenterFactory {
    companion object {
        fun createPresenter(context: Context): EventTablePresenter {

            val api: EventTableApi = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(EventTableApi::class.java)

            val dataSource: EventTableDataSource =
                EventTableDataSourceImpl(api)
            val repository: EventTableRepository =
                EventTableRepositoryImpl(dataSource)
            val interactor: EventTableInteractor = EventTableInteractorImpl(repository)

            return EventTablePresenter(interactor)
        }
    }
}
