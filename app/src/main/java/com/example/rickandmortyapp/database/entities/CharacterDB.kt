package com.example.rickandmortyapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character_table")
data class CharacterDB(

    @PrimaryKey
    val id: Long = 0

) {
}