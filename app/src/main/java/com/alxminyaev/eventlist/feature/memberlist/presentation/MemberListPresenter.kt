package com.alxminyaev.eventlist.feature.memberlist.presentation

import com.alxminyaev.eventlist.feature.MvpPresenter
import com.alxminyaev.eventlist.feature.memberlist.domain.MemberListInteractor
import io.reactivex.android.schedulers.AndroidSchedulers

class MemberListPresenter(private val interactor: MemberListInteractor) : MvpPresenter<MemberListView>() {
    override fun onViewReady() {
    }

    fun loadListMembers(eventId: Int) {
        if (eventId != -1) {
            view?.showProgressBar()
            val disposable = interactor.loadMember(eventId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.showMemberList(it)
                    view?.hideProgressBar()
                }, {
                    view?.showError()
                })
        } else {
            view?.showError()
        }

    }

}