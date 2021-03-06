package com.alxminyaev.eventlist.feature.eventtable.data.datasource.local

import com.alxminyaev.eventlist.feature.eventtable.data.datasource.remote.api.dto.TheEventCard
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.local.database.dao.CityDao
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.local.database.dao.EventDao
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.local.database.entity.CityEntity
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.local.database.entity.EventEntity
import io.reactivex.MaybeObserver
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class EventTableDataSourceLocalImpl(private val eventDao: EventDao, private val cityDao: CityDao) :
    EventTableLocalDataSource {

    override fun saveAll(list: List<TheEventCard>): Single<List<TheEventCard>> {

        val singleListEvents = Single.just(list)
        val disposableListEvent = singleListEvents.map { listEvent ->
            listEvent.map { theEvent ->
                val cites = theEvent.cities.map { theCity ->
                    convertCityFrom(theCity)
                }
                Observable.fromIterable(cites)
                    .toList()
                    .subscribeOn(Schedulers.io())
                    .subscribe(Consumer { cityDao.saveAll(it) })
                convertEventFrom(theEvent, cites.map { it.uid })
            }
        }
            .subscribeOn(Schedulers.io())
            .subscribe(Consumer { eventDao.insertAll(it) })
        return singleListEvents
    }

    override fun getEventsCards(): Single<List<TheEventCard>> {
        return eventDao.getAll()
            .subscribeOn(Schedulers.io())
            .map { list ->
                list.map { it ->
                    val citesIDs: List<Int> = it.citesId
                    val cites: MutableList<CityEntity> = mutableListOf()
                    for (id in citesIDs) {
                        cityDao.getCityById(id).subscribe { city -> cites.add(city) }
                    }
                    convertEventFrom(it, cites)
                }
            }

    }

    private fun convertEventFrom(theEventCard: TheEventCard, listIDsCites: List<Int>): EventEntity {
        return EventEntity(
            theEventCard.id,
            theEventCard.title,
            listIDsCites,
            theEventCard.description,
            EventEntity.DateEvent(theEventCard.date.start, theEventCard.date.end),
            theEventCard.cardImage,
            theEventCard.status
        )
    }

    private fun convertCityFrom(city: TheEventCard.City): CityEntity {
        return CityEntity(
            city.id,
            city.nameRus
        )
    }

    private fun convertEventFrom(eventEntity: EventEntity, citesEntity: List<CityEntity>): TheEventCard {
        val cites = citesEntity.map { convertCityFrom(it) }

        return TheEventCard(
            eventEntity.uid,
            eventEntity.title,
            cites,
            eventEntity.description,
            TheEventCard.DateEvent(eventEntity.date.start, eventEntity.date.end),
            eventEntity.cardImage,
            eventEntity.status
        )
    }

    private fun convertCityFrom(cityEntity: CityEntity): TheEventCard.City {
        return TheEventCard.City(
            cityEntity.uid,
            cityEntity.nameRus
        )
    }
}