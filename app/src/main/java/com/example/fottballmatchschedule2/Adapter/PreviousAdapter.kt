package com.example.fottballmatchschedule2.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.fottballmatchschedule2.Model.Previous
import com.example.fottballmatchschedule2.R
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class PreviousAdapter(private val Previous: List<Previous>)
    : RecyclerView.Adapter<PreviousViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviousViewHolder {
        return PreviousViewHolder(EventsUI().createView(AnkoContext.Companion.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = Previous.size

    override fun onBindViewHolder(holder: PreviousViewHolder, position: Int) {
        holder.bindItem(Previous[position])
    }

}
class EventsUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                textView {
                    id = R.id.match_event
                    textSize = 16f
                }.lparams{
                    margin = dip(15)
                }

            }
        }
    }

}
class PreviousViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val matchEvent: TextView = view.findViewById(R.id.match_event)

    fun bindItem(previous: Previous) {
        matchEvent.text = previous.matchEvent
    }
}