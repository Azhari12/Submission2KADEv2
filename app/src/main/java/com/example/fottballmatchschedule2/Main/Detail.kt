package com.example.fottballmatchschedule2.Main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import com.example.fottballmatchschedule2.Api.ApiRepository
import com.example.fottballmatchschedule2.Model.League
import com.example.fottballmatchschedule2.R
import com.google.gson.Gson
import org.jetbrains.anko.*

class Detail : AppCompatActivity(), MainVIew {
    private var leagues: MutableList<League> = mutableListOf()
    private lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val nama = intent.getStringExtra(EXTRA_NAMA)
        val gambar = intent.getIntExtra(EXTRA_GAMBAR, 0)
        //val deskripsi = intent.getStringExtra(EXTRA_DESKRIPSI)
        val idLeague = intent.getStringExtra(EXTRA_ID)

        Log.d("idleague ", idLeague)
        Log.d("gambar", gambar.toString())

        val request = ApiRepository()
        val gson = Gson()

        presenter = MainPresenter(this, request, gson)
        presenter.getLeagueDetail(idLeague)

        //var leagues: MutableList<League> = mutableListOf()
        //deskripsi = leagues.get(0).deskription
        //Log.d("Deskripsi", deskripsi)


        verticalLayout() {
            lparams(width = matchParent, height = wrapContent)
            imageView(gambar) {
                id = R.id.gambarDetail
            }.lparams {
                //width = dip(150)
                //height = dip(220)
                width = wrapContent
                height = wrapContent
                bottomMargin = dip(4)
            }
            textView(nama) {
                id = R.id.tvNamaDetail

            }
            textView() {
                id = R.id.tvDeskripsiDetail
            }

        }


    }


    override fun tambahData(data: List<League>) {
        //Log.d("dataLeague", data.toString())
        //leagues.clear()
        //leagues.addAll(data)

        //Log.d("dataleague1", leagues.size.toString())
        //Log.d("deksription", Lagues.get(0).deskription)

    }

    companion object {
        const val EXTRA_NAMA = "name"
        const val EXTRA_GAMBAR = "image"
        const val EXTRA_ID = "id"

    }

}
