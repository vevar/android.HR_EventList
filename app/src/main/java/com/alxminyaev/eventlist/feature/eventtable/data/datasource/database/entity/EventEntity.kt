package com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.entity

import android.arch.persistence.room.*


@Entity(
    tableName = EventEntity.TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = CityEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("city_id")
    )]
)
data class EventEntity(
    @PrimaryKey
    val uid: Int,
    val title: String,
    @ColumnInfo(name = "city_id") val cityId: Int,
    val description: String,
    val format: Int,
    @Embedded val date: DateEvent,
    val cardImage: String,
    val status: Int,
    val iconStatus: String,
    val eventFormat: String,
    val eventFormatEng: String
) {

    companion object {
        const val TABLE_NAME: String = "Event"
    }

    data class DateEvent(
        val start: String,
        val end: String
    )
}