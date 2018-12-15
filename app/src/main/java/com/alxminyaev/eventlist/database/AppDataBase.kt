package com.alxminyaev.eventlist.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.local.database.dao.CityDao
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.local.database.dao.EventDao
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.local.database.entity.CityEntity
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.local.database.entity.EventEntity
import com.alxminyaev.eventlist.feature.memberlist.data.datasource.local.dao.MemberListDao


@Database(entities = [EventEntity::class, CityEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME: String = "com.alxminyaev.eventlist.database"
    }

    abstract fun getEventDao(): EventDao

    abstract fun getCityDao(): CityDao

    abstract fun getMemberListDao() : MemberListDao
}