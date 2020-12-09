package com.example.rickandmortyapp.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InfoVO(

    @Json(name = "count")
    val count: Int = 0,

    @Json(name = "pages")
    val pages: Int = 0,

    @Json(name = "next")
    val nextPageUrl: String = ""


):Parcelable