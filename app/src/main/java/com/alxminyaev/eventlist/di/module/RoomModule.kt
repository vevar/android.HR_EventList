package com.alxminyaev.eventlist.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.alxminyaev.eventlist.database.AppDataBase
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    fun provideAppDataBase(context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            AppDataBase.DATABASE_NAME
        ).build()
    }

}