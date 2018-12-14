package com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = CityEntity.TABLE_NAME)
data class CityEntity(
    @PrimaryKey
    val uid: Int,
    val nameRus: String
) {
    companion object {
        const val TABLE_NAME: String = "city"
    }
}