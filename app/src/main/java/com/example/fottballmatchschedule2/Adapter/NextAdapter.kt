package com.example.fottballmatchschedule2.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.fottballmatchschedule2.Model.Next
import com.example.fottballmatchschedule2.Model.Previous
import com.example.fottballmatchschedule2.R
import org.jetbrains.anko.*

class NextAdapter(private val next: List<Next>)
    : RecyclerView.Adapter<NextViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextViewHolder {
        return NextViewHolder(EventNextUI().createView(AnkoContext.Companion.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = next.size

    override fun onBindViewHolder(holder: NextViewHolder, position: Int) {
        holder.bindItem(next[position])
    }

}
class EventNextUI : AnkoComponent<ViewGroup> {
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
class NextViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val matchEvent: TextView = view.findViewById(R.id.match_event)

    fun bindItem(next: Next) {
        matchEvent.text = next.matchEvent
    }
}