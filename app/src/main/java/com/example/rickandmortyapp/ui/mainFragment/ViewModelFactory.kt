package com.example.rickandmortyapp.ui.mainFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmortyapp.repository.CharactersRepo

class ViewModelFactory(private val repo: CharactersRepo): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainFragmentViewModel::class.java)) {
            return MainFragmentViewModel(repo) as T
        }
        throw IllegalArgumentException("Unexpected View Model ${modelClass.toString()}")
    }

}