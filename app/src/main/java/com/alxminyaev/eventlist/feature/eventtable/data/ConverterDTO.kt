package com.alxminyaev.eventlist.feature.eventtable.data

import com.alxminyaev.eventlist.feature.eventtable.data.dto.TheEventCard
import com.alxminyaev.eventlist.feature.eventtable.domain.model.DateEvent
import com.alxminyaev.eventlist.feature.eventtable.domain.model.Event
import java.text.SimpleDateFormat
import java.util.*

class ConverterDTO {
    companion object {
        fun convertToEvent(theEventCard: TheEventCard): Event {
            return Event(
                theEventCard.id,
                theEventCard.title,
                theEventCard.description,
                DateEvent(
                    SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US).parse(theEventCard.date.start),
                    SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US).parse(theEventCard.date.end)
                ),
                theEventCard.cardImage
            )
        }
    }
}
