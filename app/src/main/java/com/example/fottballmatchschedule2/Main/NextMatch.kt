package com.example.fottballmatchschedule2.Main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.fottballmatchschedule2.Adapter.NextAdapter
import com.example.fottballmatchschedule2.Adapter.PreviousAdapter
import com.example.fottballmatchschedule2.Api.ApiRepository
import com.example.fottballmatchschedule2.Model.League
import com.example.fottballmatchschedule2.Model.Next
import com.example.fottballmatchschedule2.Model.Previous
import com.google.gson.Gson
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.wrapContent

class NextMatch : AppCompatActivity(), MainVIew {
    override fun tambahData(data: List<League>) {

    }

    override fun showPreviousList(data: List<Previous>) {
    }



    private lateinit var idLeague: String
    private var next: MutableList<Next> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: NextAdapter
    private lateinit var listNext: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        idLeague = intent.getStringExtra(EXTRA_ID)
        Log.d("idLeaguediPrevious", idLeague)

        relativeLayout {
            lparams(width = matchParent, height = wrapContent)

            listNext = recyclerView {
                lparams(width = matchParent, height = wrapContent)
                layoutManager = LinearLayoutManager(context)
            }
        }

        adapter = NextAdapter(next)
        listNext.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()
        presenter = MainPresenter(this,request,gson)
        presenter.getNextMatch(idLeague)
    }
    override fun showNextList(data: List<Next>) {
        next.clear()
        next.addAll(data)
        adapter.notifyDataSetChanged()
    }
    companion object {
        const val EXTRA_ID = "id"

    }
}
