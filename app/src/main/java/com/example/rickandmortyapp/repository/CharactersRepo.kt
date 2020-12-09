package com.example.rickandmortyapp.repository

import com.example.rickandmortyapp.core.toCharacterDB
import com.example.rickandmortyapp.core.toCharacterVO
import com.example.rickandmortyapp.database.dao.RickAndMortyDao
import com.example.rickandmortyapp.network.RickAndMortyApiService
import com.example.rickandmortyapp.network.models.CharacterVO

class CharactersRepo(private val localSource: RickAndMortyDao, private val remoteSource: RickAndMortyApiService) {
    suspend fun getCharacters(cachePolicies: CachePolicies, page : Int): List<CharacterVO> {
        return when (cachePolicies){
            CachePolicies.NETWORK -> {
                val characters = remoteSource.getCharacters(page).listOfCharacters
                localSource.deleteAllCharacters()
                localSource.insertCharacters(characters.map{ it.toCharacterDB()})
                characters
            }
            CachePolicies.CACHE -> localSource.getAllCharacters().map { it.toCharacterVO() }
        }
    }


}