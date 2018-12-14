package com.alxminyaev.eventlist.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.dao.CityDao
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.dao.EventDao
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.entity.CityEntity
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.entity.EventEntity


@Database(entities = [EventEntity::class, CityEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME: String = "com.alxminyaev.eventlist.database"
    }

    abstract fun getEventDao(): EventDao

    abstract fun getCityDao(): CityDao

}