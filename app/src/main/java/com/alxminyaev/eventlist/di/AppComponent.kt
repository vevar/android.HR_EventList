package com.alxminyaev.eventlist.di

import com.alxminyaev.eventlist.di.module.ActivityModule
import com.alxminyaev.eventlist.di.module.RetrofitModule
import com.alxminyaev.eventlist.di.module.RoomModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityModule::class, RoomModule::class, RetrofitModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }
}