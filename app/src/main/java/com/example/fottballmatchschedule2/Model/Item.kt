package com.example.fottballmatchschedule2.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(val name: String?, val image: Int?, val idLeague: String) : Parcelable