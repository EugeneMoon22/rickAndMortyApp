package com.example.rickandmortyapp.database.dao

import androidx.room.*
import com.example.rickandmortyapp.database.entities.CharacterDB
@Dao
interface RickAndMortyDao {
    companion object {
        const val TABLE_NAME = "character_table"
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(Character: CharacterDB)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(Characters: List<CharacterDB>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCharacters(Character: CharacterDB)

    @Delete
    suspend fun deleteCharacters(Character: CharacterDB)

    @Query("DELETE FROM $TABLE_NAME")
    suspend fun deleteAllCharacters()

    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun getAllCharacters(): List<CharacterDB>

    @Query("SELECT * FROM $TABLE_NAME WHERE id=:CharacterId LIMIT 1")
    suspend fun getCharacter(CharacterId: Int): CharacterDB

    @Query("SELECT EXISTS (SELECT * FROM $TABLE_NAME WHERE id = :CharacterId)")
    suspend fun isCharacterExists(CharacterId: Int): Boolean


}