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

    override fun saveAllToLocal(list: List<EventModel>) {
//        dataSourceLocal.saveAll(list.map { eventModel ->
////            TheEventCard(
////                eventModel.id,
////                eventModel.title,
////                eventModel.cites,
////                eventModel.description,
////                eventModel.date,
////                eventModel.cardImage,
////                eventModel.status
////            )
//        })
    }

    override fun loadEventsFromLocal(): Single<List<EventModel>> {
        return dataSourceLocal.getEventsCards().map { list ->
            list.map {
                convertFrom(it)
            }
        }
    }

    override fun loadEventsFromRemote(): Single<List<EventModel>> {
        return dataSourceRemote.getEventsCards().map { list ->
            list.map {
                convertFrom(it)
            }
        }

    }

    private fun convertFrom(theEventCard: TheEventCard): EventModel {
        return EventModel(
            theEventCard.id,
            theEventCard.title,
            theEventCard.cities.map { convertFrom(it) },
            theEventCard.description,
            DateEventModel(
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US).parse(theEventCard.date.start),
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US).parse(theEventCard.date.end)
            ),
            theEventCard.cardImage,
            theEventCard.status
        )
    }

    private fun convertFrom(city: TheEventCard.City): CityModel {
        return CityModel(
            city.id,
            city.nameRus
        )
    }
}
