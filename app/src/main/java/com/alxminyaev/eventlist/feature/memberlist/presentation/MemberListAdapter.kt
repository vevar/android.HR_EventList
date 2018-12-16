package com.alxminyaev.eventlist.feature.memberlist.presentation

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.alxminyaev.eventlist.R
import com.alxminyaev.eventlist.feature.memberlist.domain.model.MemberShort

class MemberListAdapter(context: Context) : RecyclerView.Adapter<MemberListAdapter.MemberListHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val memberList: MutableList<MemberShort> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberListHolder {
        val view = inflater.inflate(R.layout.member_card, parent, false)
        return MemberListHolder(view)
    }

    override fun getItemCount(): Int {
        return memberList.size
    }

    override fun onBindViewHolder(memberListHolder: MemberListHolder, position: Int) {
        memberListHolder.bind(memberList[position])
    }

    fun setMemberList(memberList: List<MemberShort>) {
        this.memberList.clear()
        this.memberList.addAll(memberList)
        notifyDataSetChanged()
    }

    class MemberListHolder(view: View) : RecyclerView.ViewHolder(view) {

        val firstName: TextView = view.findViewById(R.id.member_first_name)
        val secondName: TextView = view.findViewById(R.id.member_second_name)
        val isVisited: CheckBox = view.findViewById(R.id.member_visited)

        fun bind(memberShort: MemberShort) {
            firstName.text = memberShort.firstName
            secondName.text = memberShort.lastName
        }

    }

}
