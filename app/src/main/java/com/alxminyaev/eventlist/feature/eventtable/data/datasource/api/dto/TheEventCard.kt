package com.alxminyaev.eventlist.feature.eventtable.data.datasource.api.dto

data class TheEventCard(
    val id: Int,
    val title: String,
    val cities: List<City>,
    val description: String,
    val date: DateEvent,
    val cardImage: String,
    val status: Int
) {

    data class City(
        val id: Int,
        val nameRus: String
    )

    data class DateEvent(
        val start: String,
        val end: String
    )
}