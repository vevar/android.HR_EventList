package com.alxminyaev.eventlist.feature.eventtable.data.repository

import com.alxminyaev.eventlist.feature.eventtable.data.datasource.EventTableDataSource
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.api.dto.TheEventCard
import com.alxminyaev.eventlist.feature.eventtable.domain.model.CityModel
import com.alxminyaev.eventlist.feature.eventtable.domain.model.DateEventModel
import com.alxminyaev.eventlist.feature.eventtable.domain.model.EventModel
import io.reactivex.Single
import java.text.SimpleDateFormat
import java.util.*

class EventTableRepositoryImpl(
    private val dataSourceRemote: EventTableDataSource,
    private val dataSourceLocal: EventTableDataSource
) : EventTableRepository {

    override fun saveAllToLocal(single: Single<List<EventModel>>) {
        dataSourceLocal.saveAll(single.map { list ->
            list.map {
                convertEventFrom(it)
            }
        })
    }

    override fun loadEventsFromLocal(): Single<List<EventModel>> {
        return dataSourceLocal.getEventsCards().map { list ->
            list.map {
                convertEventFrom(it)
            }
        }
    }

    override fun loadEventsFromRemote(): Single<List<EventModel>> {
        return dataSourceRemote.getEventsCards().map { list ->
            list.map {
                convertEventFrom(it)
            }
        }

    }

    private fun convertDateFrom(dateEventModel: DateEventModel): TheEventCard.DateEvent {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
        return TheEventCard.DateEvent(
            simpleDateFormat.format(dateEventModel.start),
            simpleDateFormat.format(dateEventModel.end)
        )
    }

    private fun convertDateFrom(dateEvent: TheEventCard.DateEvent): DateEventModel {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
        return DateEventModel(
            simpleDateFormat.parse(dateEvent.start),
            simpleDateFormat.parse(dateEvent.end)
        )
    }

    private fun convertCityFrom(cityModel: CityModel): TheEventCard.City {
        return TheEventCard.City(
            cityModel.id,
            cityModel.nameRus
        )
    }

    private fun convertEventFrom(eventModel: EventModel): TheEventCard {
        return TheEventCard(
            eventModel.id,
            eventModel.title,
            eventModel.cites.map { convertCityFrom(it) },
            eventModel.description,
            convertDateFrom(eventModel.date),
            eventModel.cardImage,
            eventModel.status
        )
    }

    private fun convertEventFrom(theEventCard: TheEventCard): EventModel {
        return EventModel(
            theEventCard.id,
            theEventCard.title,
            theEventCard.cities.map { convertCityFrom(it) },
            theEventCard.description,
            convertDateFrom(theEventCard.date),
            theEventCard.cardImage,
            theEventCard.status
        )
    }

    private fun convertCityFrom(city: TheEventCard.City): CityModel {
        return CityModel(
            city.id,
            city.nameRus
        )
    }
}
