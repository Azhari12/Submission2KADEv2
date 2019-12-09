package com.example.fottballmatchschedule2.Main

import android.util.Log
import com.example.fottballmatchschedule2.Api.ApiRepository
import com.example.fottballmatchschedule2.Api.TheSportDBApi
import com.example.fottballmatchschedule2.Model.LeagueResponse
import com.example.fottballmatchschedule2.Model.NextResponse
import com.example.fottballmatchschedule2.Model.PreviousResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(
    private val view: MainVIew,
    private val apiRepository: ApiRepository,
    private val gson: Gson

){
    fun getLeagueDetail(league: String) {
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getDetail(league)),
                LeagueResponse::class.java
            )

             uiThread {
                  view.tambahData(data.leagues)
            }
        }
    }

    fun getPreviousMatch(idleague: String) {
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getPrevious(idleague)),
                PreviousResponse::class.java
            )

            uiThread {
                view.showPreviousList(data.events)
            }
        }
    }

    fun getNextMatch(idleague: String) {
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getNext(idleague)),
                NextResponse::class.java
            )

            uiThread {
                view.showNextList(data.events)
            }
        }
    }
}