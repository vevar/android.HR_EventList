package com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.entity.EventEntity


@Dao
interface EventDao {
    @Query("SELECT * FROM ${EventEntity.TABLE_NAME}")
    fun getAll(): List<EventEntity>
}