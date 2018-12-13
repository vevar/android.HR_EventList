package com.alxminyaev.eventlist.feature

abstract class MvpPresenter<T : MvpView> {

    protected var view: T? = null

    fun attachView(view: T) {
        this.view = view
        onViewReady()
    }

    fun detachView() {
        view = null
    }

    protected abstract fun onViewReady()
}