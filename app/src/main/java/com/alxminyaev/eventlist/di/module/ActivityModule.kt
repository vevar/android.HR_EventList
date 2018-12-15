package com.alxminyaev.eventlist.di.module

import com.alxminyaev.eventlist.feature.eventtable.presentation.EventTableActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeEventTableActivity(): EventTableActivity
}