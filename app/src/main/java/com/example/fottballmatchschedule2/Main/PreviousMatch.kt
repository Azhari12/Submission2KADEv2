package com.example.fottballmatchschedule2.Main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.fottballmatchschedule2.Adapter.PreviousAdapter
import com.example.fottballmatchschedule2.Api.ApiRepository
import com.example.fottballmatchschedule2.Model.League
import com.example.fottballmatchschedule2.Model.Next
import com.example.fottballmatchschedule2.Model.Previous
import com.example.fottballmatchschedule2.R
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class PreviousMatch : AppCompatActivity(),MainVIew {
    override fun showNextList(data: List<Next>) {

    }

    override fun tambahData(data: List<League>) {

    }

    private lateinit var idLeague: String
    private var Previous: MutableList<Previous> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: PreviousAdapter
    private lateinit var listPrevious: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        idLeague = intent.getStringExtra(EXTRA_ID)
        Log.d("idLeaguediPrevious",idLeague)

        relativeLayout{
            lparams(width= matchParent, height = wrapContent)

            listPrevious = recyclerView{
                lparams(width= matchParent, height = wrapContent)
                layoutManager = LinearLayoutManager(context)
            }
        }

        adapter = PreviousAdapter(Previous)
        listPrevious.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()
        presenter = MainPresenter(this,request,gson)
        presenter.getPreviousMatch(idLeague)
    }

    override fun showPreviousList(data: List<Previous>){

        Previous.clear()
        Previous.addAll(data)
        adapter.notifyDataSetChanged()
    }

    companion object {
        const val EXTRA_ID = "id"

    }
}
