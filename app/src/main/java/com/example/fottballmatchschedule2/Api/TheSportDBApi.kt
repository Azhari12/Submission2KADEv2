package com.example.fottballmatchschedule2.Api

import android.net.Uri
import com.example.fottballmatchschedule2.BuildConfig

object TheSportDBApi {
    fun getDetail(idLeague: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("lookupleague.php")
            .appendQueryParameter("id", idLeague)
            .build()
            .toString()
    }

    fun getPrevious(idLeague: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("eventspastleague.php")
            .appendQueryParameter("id", idLeague)
            .build()
            .toString()
    }

    fun getNext(idLeague: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("eventsnextleague.php")
            .appendQueryParameter("id", idLeague)
            .build()
            .toString()
    }
}