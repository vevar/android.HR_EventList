package com.alxminyaev.eventlist.feature.eventtable.domain.model

data class EventModel(
    val id: Int,
    val title: String,
    val cites : List<CityModel>,
    val description: String,
    val date: DateEventModel,
    val cardImage: String,
    val status : Int
)