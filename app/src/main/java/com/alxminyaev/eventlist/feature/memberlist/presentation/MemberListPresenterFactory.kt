package com.alxminyaev.eventlist.feature.memberlist.presentation

import android.content.Context
import com.alxminyaev.eventlist.App
import com.alxminyaev.eventlist.feature.memberlist.data.datasource.local.MemberListDataSourceLocalImpl
import com.alxminyaev.eventlist.feature.memberlist.data.datasource.local.MemberListLocalDataSource
import com.alxminyaev.eventlist.feature.memberlist.data.datasource.remote.MemberListRemoteDataSource
import com.alxminyaev.eventlist.feature.memberlist.data.datasource.remote.MemberListRemoteDataSourceImpl
import com.alxminyaev.eventlist.feature.memberlist.data.datasource.remote.api.MemberListApi
import com.alxminyaev.eventlist.feature.memberlist.data.repository.MemberListRepository
import com.alxminyaev.eventlist.feature.memberlist.data.repository.MemberListRepositoryImpl
import com.alxminyaev.eventlist.feature.memberlist.domain.MemberListInteractor
import com.alxminyaev.eventlist.feature.memberlist.domain.MemberListInteractorImpl

class MemberListPresenterFactory {
    companion object {
        fun createPresenter(context: Context): MemberListPresenter {
            val api: MemberListApi = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(MemberListApi::class.java)


            val dataSourceRemote: MemberListRemoteDataSource =
                MemberListRemoteDataSourceImpl(api)
            val dataSourceLocal: MemberListLocalDataSource =
                MemberListDataSourceLocalImpl(
                    App.getAppDataBase(context).getMemberListDao()
                )

            val repository: MemberListRepository =
                MemberListRepositoryImpl(dataSourceRemote, dataSourceLocal)

            val interactor: MemberListInteractor = MemberListInteractorImpl(repository)

            return MemberListPresenter(interactor)
        }
    }
}