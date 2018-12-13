package com.alxminyaev.eventlist.feature.eventtable.data.dto

data class TheEventCard(
    val id: Int,
    val title: String,
    val listCites: List<City>,
    val description: String,
    val format: Int,
    val date: DateEvent,
    val cardImage: String,
    val status: Int,
    val iconStatus: String,
    val eventFormat: String,
    val eventFormatEng: String
) {

    data class City(
        val id: Int,
        val nameRus: String,
        val nameEng: String,
        val icon: String,
        val isActive: Boolean
    )

    data class DateEvent(
        val start: String,
        val end: String
    )
}