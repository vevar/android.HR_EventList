package com.alxminyaev.eventlist.feature.feature

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<T : MvpView> : AppCompatActivity() {

    protected abstract fun getPresenter(): MvpPresenter<T>

    protected abstract fun getMvpView(): T

    private lateinit var presenter: MvpPresenter<T>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = getPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(getMvpView())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}