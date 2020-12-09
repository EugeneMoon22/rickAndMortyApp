package com.example.rickandmortyapp.ui.mainFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.network.models.CharacterVO
import com.example.rickandmortyapp.repository.CachePolicies
import com.example.rickandmortyapp.repository.CharactersRepo
import kotlinx.coroutines.*
import java.lang.Exception

class MainFragmentViewModel (private val repository: CharactersRepo): ViewModel() {

    private val _storage = MutableLiveData<List<CharacterVO>>()
    val storage: LiveData<List<CharacterVO>>
    get() = _storage

    private var _downloadedPages = 0
    val downloadedPages: Int
    get() = _downloadedPages


    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    fun getAllCharacters() {
        uiScope.launch {
            try {
                _storage.value = repository.getCharacters(CachePolicies.NETWORK, 1)
            } catch (ex: Exception) {
                Log.e("MainFragmentViewModel", "something goes wrong in getAllCharacters")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    companion object {
        const val NUMBER_OF_PAGES = 34
        const val NUMBER_OF_CHARACTERS = 671
    }

}