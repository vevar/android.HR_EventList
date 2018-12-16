package com.alxminyaev.eventlist.feature.memberlist.data.datasource.remote.dto

data class TheMember(
    val id: Int,
    val phone: String,
    val city: String,
    val company: String,
    val position: String,
    val lastName: String,
    val firstName: String,
    val patronymic: String,
    val email: String
)