package com.alxminyaev.eventlist.feature.eventtable.domain.model

data class Event(
    val id: Int,
    val title: String,
    val description: String,
    val date: DateEvent,
    val cardImage: String
)