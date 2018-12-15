package com.alxminyaev.eventlist.feature.eventtable.presentation

import android.content.Context
import com.alxminyaev.eventlist.App
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.remote.api.EventTableApi
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.local.EventTableLocalDataSource
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.local.EventTableDataSourceLocalImpl
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.remote.EventTableDataSourceRemoteImpl
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.remote.EventTableRemoteDataSource
import com.alxminyaev.eventlist.feature.eventtable.data.repository.EventTableRepository
import com.alxminyaev.eventlist.feature.eventtable.data.repository.EventTableRepositoryImpl
import com.alxminyaev.eventlist.feature.eventtable.domain.EventTableInteractor
import com.alxminyaev.eventlist.feature.eventtable.domain.EventTableInteractorImpl

class PresenterFactory {
    companion object {
        fun createPresenter(context: Context): EventTablePresenter {

            val api: EventTableApi = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(EventTableApi::class.java)


            val dataSourceRemote: EventTableRemoteDataSource =
                EventTableDataSourceRemoteImpl(api)
            val dataSourceLocal: EventTableLocalDataSource =
                EventTableDataSourceLocalImpl(
                    App.getAppDataBase(context).getEventDao(),
                    App.getAppDataBase(context).getCityDao()
                )

            val repository: EventTableRepository =
                EventTableRepositoryImpl(dataSourceRemote, dataSourceLocal)

            val interactor: EventTableInteractor = EventTableInteractorImpl(repository)

            return EventTablePresenter(interactor)
        }
    }
}
