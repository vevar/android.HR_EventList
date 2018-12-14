package com.alxminyaev.eventlist.feature.eventtable.data.datasource

import com.alxminyaev.eventlist.feature.eventtable.data.datasource.api.dto.TheEventCard
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.dao.CityDao
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.dao.EventDao
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.entity.CityEntity
import com.alxminyaev.eventlist.feature.eventtable.data.datasource.database.entity.EventEntity
import io.reactivex.MaybeObserver
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class EventTableDataSourceLocalImpl(private val eventDao: EventDao, private val cityDao: CityDao) :
    EventTableDataSource {

    override fun saveAll(list: List<TheEventCard>) {
        eventDao.insertAll(list.map {
            val cites: List<CityEntity> = it.cities.map { city ->
                convertFrom(city)
            }
            cityDao.saveAll(cites)
            convertFrom(it, cites.map { it.uid })
        })
    }

    override fun getEventsCards(): Single<List<TheEventCard>> {
        return eventDao.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { list ->
                list.map {
                    val citesIDs: List<Int> = it.citesId
                    val cites: MutableList<CityEntity> = mutableListOf()
                    for (id in citesIDs) {
                        cityDao.getCityById(id).subscribe(object : MaybeObserver<CityEntity> {
                            override fun onSuccess(cityEntity: CityEntity) {
                                cites.add(cityEntity)
                            }

                            override fun onComplete() {
                            }

                            override fun onSubscribe(d: Disposable) {
                            }

                            override fun onError(e: Throwable) {
                            }

                        })
                    }
                    convertFrom(it, cites)
                }
            }

    }

    private fun convertFrom(theEventCard: TheEventCard, listIDsCites: List<Int>): EventEntity {
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

    private fun convertFrom(city: TheEventCard.City): CityEntity {
        return CityEntity(
            city.id,
            city.nameRus
        )
    }

    private fun convertFrom(eventEntity: EventEntity, citesEntity: List<CityEntity>): TheEventCard {
        val cites = citesEntity.map { convertFrom(it) }

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

    private fun convertFrom(cityEntity: CityEntity): TheEventCard.City {
        return TheEventCard.City(
            cityEntity.uid,
            cityEntity.nameRus
        )
    }
}