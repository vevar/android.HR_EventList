package com.alxminyaev.eventlist.feature.eventtable.presentation

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alxminyaev.eventlist.R
import com.alxminyaev.eventlist.feature.eventtable.domain.model.EventModel
import java.util.*

class EventTableAdapter(context: Context, private val selectEventListener: SelectEventListener) :
    RecyclerView.Adapter<EventTableAdapter.EventHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val listEvents: MutableList<EventModel> = mutableListOf()
    private val months = context.resources.getStringArray(R.array.months)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        val view = inflater.inflate(R.layout.event_card, parent, false)

        return EventHolder(view, selectEventListener)
    }

    override fun getItemCount(): Int {
        return listEvents.size
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.bind(listEvents[position], months)
    }

    fun setListEvents(events: List<EventModel>) {
        listEvents.clear()
        listEvents.addAll(events)
        notifyDataSetChanged()
    }

    class EventHolder(view: View, private val selectEventListener: SelectEventListener) :
        RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.event_title)
        private val dateStart = view.findViewById<TextView>(R.id.event_date)


        fun bind(event: EventModel, months: Array<String>) {
            title.text = event.title
            dateStart.text = convertDate(event.date.start, months)

            itemView.setOnClickListener {
                selectEventListener.OnEventSelect(event)
            }
        }

        private fun convertDate(calendar: Calendar, months: Array<String>): String {
            return "${calendar.get(Calendar.DAY_OF_MONTH)}" +
                    " ${months[calendar.get(Calendar.MONTH)]}" +
                    " ${calendar.get(Calendar.YEAR)}"
        }
    }

    interface SelectEventListener {
        fun OnEventSelect(event: EventModel)
    }
}


