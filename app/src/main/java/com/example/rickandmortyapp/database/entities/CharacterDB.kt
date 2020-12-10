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

    @ColumnInfo(name = "name")
    val name: String = "",

    @ColumnInfo(name = "imageUrl")
    val image: String = "",

    @ColumnInfo(name = "status")
    val status: String

) : Parcelable
