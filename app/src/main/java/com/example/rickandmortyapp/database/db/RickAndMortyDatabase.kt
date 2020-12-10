package com.example.rickandmortyapp.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickandmortyapp.database.dao.RickAndMortyDao
import com.example.rickandmortyapp.database.entities.CharacterDB

@Database(
    entities = [CharacterDB::class],
    version = RickAndMortyDatabase.DATABASE_VERSION,
    exportSchema = false
)


abstract class RickAndMortyDatabase : RoomDatabase()
{
    companion object {
        const val DATABASE_NAME = "CHARACTERS_DATABASE.db"
        const val DATABASE_VERSION = 2
        @Volatile
        private var INSTANCE: RickAndMortyDatabase? = null
        fun getInstance(context: Context):RickAndMortyDatabase{ synchronized(this){
            var instance = INSTANCE
            if (instance == null){
                instance = Room.databaseBuilder(context.applicationContext, RickAndMortyDatabase::class.java,
                    DATABASE_NAME).fallbackToDestructiveMigration().build()
                INSTANCE = instance

            }
            return instance

        }

        }
    }
abstract val rickAndMortyDao : RickAndMortyDao

}