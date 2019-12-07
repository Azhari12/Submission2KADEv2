package com.example.fottballmatchschedule2.Main

import android.util.Log
import com.example.fottballmatchschedule2.Api.ApiRepository
import com.example.fottballmatchschedule2.Api.TheSportDBApi
import com.example.fottballmatchschedule2.Model.LeagueResponse
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
                    .doRequest(TheSportDBApi.getDetail("4328")),
                LeagueResponse::class.java
            )

             uiThread {
                  view.tambahData(data.liga)
            }
        }
    }
}