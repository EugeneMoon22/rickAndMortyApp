package com.example.rickandmortyapp.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultsVO(

    val listOfCharacters: List<CharacterVO>

):Parcelable
