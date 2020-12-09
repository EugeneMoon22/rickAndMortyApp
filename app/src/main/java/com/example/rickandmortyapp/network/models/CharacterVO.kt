package com.example.rickandmortyapp.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterVO(
    @Json(name = "id")
    val id: Int,

    @Json(name ="image")
    val image: String,

    @Json(name = "name")
    val name: String) : Parcelable