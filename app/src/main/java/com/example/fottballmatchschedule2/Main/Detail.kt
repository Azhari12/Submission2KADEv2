package com.example.fottballmatchschedule2.Main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import com.example.fottballmatchschedule2.Api.ApiRepository
import com.example.fottballmatchschedule2.Model.League
import com.example.fottballmatchschedule2.Model.Next
import com.example.fottballmatchschedule2.Model.Previous
import com.example.fottballmatchschedule2.R
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class Detail : MainVIew, AppCompatActivity() {
    override fun showNextList(data: List<Next>) {

    }

    override fun showPreviousList(data: List<Previous>) {

    }

    private var leagues: MutableList<League> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var deskripsi: String
    private lateinit var idLeague: String
    override fun tambahData(data: List<League>) {

        val nama = intent.getStringExtra(EXTRA_NAMA)
        val gambar = intent.getIntExtra(EXTRA_GAMBAR, 0)
        //val deskripsi = intent.getStringExtra(EXTRA_DESKRIPSI)

        //Log.d("dataLeague", data.toString())
        leagues.clear()
        leagues.addAll(data)

        deskripsi = leagues.get(0).deskription

        Log.d("dataleague1", leagues.size.toString())
        Log.d("deksription", leagues.get(0).deskription)

        relativeLayout() {
            lparams(width = matchParent, height = wrapContent)
            button("Previous Match") {
                id = R.id.btn_previousMatch
                onClick {
                    startActivity<PreviousMatch>(
                        "id" to idLeague
                    )
                }
            }.lparams {

            }
            button("Next Match") {
                id = R.id.btn_NextMatch
                onClick {
                    startActivity<NextMatch>(
                        "id" to idLeague
                    )
                }
            }.lparams {
                rightOf(R.id.btn_previousMatch)
            }
            imageView(gambar) {
                id = R.id.gambarDetail

            }.lparams {
                //width = dip(150)
                //height = dip(220)
                width = wrapContent
                height = wrapContent
                bottomMargin = dip(4)
                bottomOf(R.id.btn_previousMatch)
            }
            textView(nama) {
                id = R.id.tvNamaDetail

            }.lparams {
                bottomOf(R.id.gambarDetail)
            }
            textView(deskripsi) {
                id = R.id.tvDeskripsiDetail
            }.lparams {
                bottomOf(R.id.tvNamaDetail)
            }

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        idLeague = intent.getStringExtra(EXTRA_ID)

        // Log.d("idleague ", idLeague)
        //Log.d("gambar", gambar.toString())

        val request = ApiRepository()
        val gson = Gson()

        presenter = MainPresenter(this, request, gson)
        presenter.getLeagueDetail(idLeague)

        //var leagues: MutableList<League> = mutableListOf()

        // Log.d("Deskripsi", deskripsi)


    }


    companion object {
        const val EXTRA_NAMA = "name"
        const val EXTRA_GAMBAR = "image"
        const val EXTRA_ID = "id"

    }

}
