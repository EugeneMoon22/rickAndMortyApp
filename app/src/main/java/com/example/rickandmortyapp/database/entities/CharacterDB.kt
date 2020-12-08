package com.example.rickandmortyapp.database.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "character_table")
data class CharacterDB(

    @PrimaryKey
    val id: Int = 0,
    @ColumnInfo
    val name: String = "",
    @ColumnInfo
    val image: String = ""

) : Parcelable
