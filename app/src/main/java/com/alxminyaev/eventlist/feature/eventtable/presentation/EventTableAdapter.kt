package com.alxminyaev.eventlist.feature.eventtable.presentation

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alxminyaev.eventlist.R
import com.alxminyaev.eventlist.feature.eventtable.domain.model.Event

class EventTableAdapter(context: Context) : RecyclerView.Adapter<EventTableAdapter.EventHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val listEvents: MutableList<Event> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        val view = inflater.inflate(R.layout.event_card, parent, false)
        return EventHolder(view)
    }

    override fun getItemCount(): Int {
        return listEvents.size
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.bind(listEvents[position])
    }

    fun setListEvents(events: List<Event>) {
        listEvents.clear()
        listEvents.addAll(events)
        notifyDataSetChanged()
    }

    class EventHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var title = view.findViewById<TextView>(R.id.event_title)
        private var dateStart = view.findViewById<TextView>(R.id.event_date)


        fun bind(event: Event) {
            title.text = event.title
            dateStart.text = event.date.start.toString()
        }
    }
}