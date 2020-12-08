package com.example.rickandmortyapp.network

import com.example.rickandmortyapp.network.models.CharacterVO
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://rickandmortyapi.com/api"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface RickAndMortyApiService {

    @GET("character")
    suspend fun getCharacters(@Query("pages") pages: Int): List<CharacterVO>
    @GET("character")
    suspend fun getCharacter(@Query("id") id: Int): CharacterVO



}

object RickAndMortyApi {
    val retrofitService: RickAndMortyApiService by lazy {
        retrofit.create(RickAndMortyApiService::class.java)
    }
}