package com.example.fottballmatchschedule2.Main

import com.example.fottballmatchschedule2.Model.League
import com.example.fottballmatchschedule2.Model.Next
import com.example.fottballmatchschedule2.Model.Previous

interface MainVIew {
    fun tambahData(data: List<League>)

    fun showPreviousList(data: List<Previous>)

    fun showNextList(data: List<Next>)
}