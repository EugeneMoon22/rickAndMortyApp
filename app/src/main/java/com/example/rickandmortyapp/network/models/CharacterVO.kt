package com.example.rickandmortyapp.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterVO(
    val id: Int,
    @Json(name ="image") val image: String,
    val name: String) : Parcelable{}