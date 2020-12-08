package com.example.rickandmortyapp.core

import com.example.rickandmortyapp.database.entities.CharacterDB
import com.example.rickandmortyapp.network.models.CharacterVO

fun CharacterDB.toCharacterVO () = CharacterVO(
    id,
    name,
    image
)
fun CharacterVO.toCharacterDB () = CharacterDB(
    id,
    name,
    image
)