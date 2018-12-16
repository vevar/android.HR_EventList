package com.alxminyaev.eventlist.feature.memberlist.presentation

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alxminyaev.eventlist.R
import com.alxminyaev.eventlist.feature.memberlist.domain.model.Member

class MemberListAdapter(context: Context) : RecyclerView.Adapter<MemberListAdapter.MemberListHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val memberList: MutableList<Member> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberListHolder {
        inflater.inflate(R.layout.member_card,parent,false)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(p0: MemberListHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class MemberListHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

}
