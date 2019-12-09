package com.example.fottballmatchschedule2.Model

import com.google.gson.annotations.SerializedName

data class Previous(
    @SerializedName("strEvent")
    var matchEvent: String? = null
)