package com.alxminyaev.eventlist.feature.eventtable.data.datasource.local.database.entity

import android.arch.persistence.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@Entity(
    tableName = EventEntity.TABLE_NAME
)
@TypeConverters(EventEntity.Converter::class)
data class EventEntity(
    @PrimaryKey
    val uid: Int,
    val title: String,
    @ColumnInfo(name = EventEntity.CITIES_ID) val citesId: List<Int>,
    val description: String,
    @Embedded val date: DateEvent,
    val cardImage: String,
    val status: Int
) {
    data class DateEvent(
        val start: String,
        val end: String
    )

    companion object {
        const val TABLE_NAME: String = "event"
        const val CITIES_ID: String = "cites_id"
    }

    class Converter {
        @TypeConverter
        fun listIDsToString(list: List<Int>): String {
            return Gson().toJson(list).toString()
        }

        @TypeConverter
        fun stringIDsToList(stringIDs: String): List<Int> {
            return Gson().fromJson<List<Int>>(stringIDs, object : TypeToken<List<Int>>() {}.type)
        }
    }
}