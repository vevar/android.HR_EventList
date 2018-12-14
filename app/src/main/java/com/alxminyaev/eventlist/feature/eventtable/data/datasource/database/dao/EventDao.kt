package com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.entity.EventEntity
import io.reactivex.Single


@Dao
interface EventDao {

    @Query("SELECT * FROM ${EventEntity.TABLE_NAME}")
    fun getAll(): Single<List<EventEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(events: List<EventEntity>)

}