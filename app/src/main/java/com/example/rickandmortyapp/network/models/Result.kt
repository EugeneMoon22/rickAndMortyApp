package com.example.rickandmortyapp.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Result(

    @Json(name = "info")
    val info: InfoVO,

    @Json(name = "results")
    val listOfCharacters: List<CharacterVO>

): Parcelable

