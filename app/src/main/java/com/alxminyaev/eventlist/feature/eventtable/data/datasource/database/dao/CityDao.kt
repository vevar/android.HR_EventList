package com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.entity.CityEntity
import io.reactivex.Maybe

@Dao
interface CityDao {

    @Query("SELECT * FROM ${CityEntity.TABLE_NAME} WHERE uid LIKE :id")
    fun getCityById(id: Int): Maybe<CityEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(city: CityEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(list: List<CityEntity>)


}