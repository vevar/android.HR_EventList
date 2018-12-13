package com.alxminyaev.eventlist.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.dao.EventDao
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.entity.CityEntity
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.entity.EventEntity


@Database(entities = arrayOf(EventEntity::class, CityEntity::class), version = 2)
abstract class AppDataBase : RoomDatabase() {

    companion object {
        val DATABASE_NAME: String = "com.alxminyaev.eventlist.database"
    }

    abstract fun getEventDao(): EventDao

}