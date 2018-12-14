package com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.entity

import android.arch.persistence.room.*
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.api.dto.TheEventCard
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@Entity(
    tableName = EventEntity.TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = CityEntity::class,
        parentColumns = arrayOf("uid"),
        childColumns = arrayOf("cites_id")
    )]
)
@TypeConverters(EventEntity.Converter::class)
data class EventEntity(
    @PrimaryKey
    val uid: Int,
    val title: String,
    @ColumnInfo(name = "cites_id") val citesId: List<Int>,
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
        fun convertFrom(theEventCard: TheEventCard): EventEntity {
            return EventEntity(
                theEventCard.id,
                theEventCard.title,
                theEventCard.cities.map { city -> city.id },
                theEventCard.description,
                EventEntity.DateEvent(theEventCard.date.start, theEventCard.date.end),
                theEventCard.cardImage,
                theEventCard.status
            )
        }

        const val TABLE_NAME: String = "event"
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