package com.ozancanguz.footballzonepro.data.results

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    val away: String,
    val date: String,
    val home: String,
    val skor: String
):Parcelable