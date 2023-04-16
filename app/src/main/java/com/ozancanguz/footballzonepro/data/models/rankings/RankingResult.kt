package com.ozancanguz.footballzonepro.data.models.rankings

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RankingResult(
    val draw: Int,
    val goalagainst: Int,
    val goaldistance: Int,
    val goalfor: Int,
    val lose: Int,
    val play: Int,
    val point: Int,
    val rank: Int,
    val team: String,
    val win: Int
):Parcelable