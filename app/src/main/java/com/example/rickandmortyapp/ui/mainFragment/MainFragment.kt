package com.example.rickandmortyapp.ui.mainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.database.db.RickAndMortyDatabase
import com.example.rickandmortyapp.databinding.FragmentMainBinding
import com.example.rickandmortyapp.network.RickAndMortyApi
import com.example.rickandmortyapp.repository.CharactersRepo
import java.util.concurrent.AbstractExecutorService

class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding

    private lateinit var viewModel: MainFragmentViewModel

    private lateinit var repository: CharactersRepo
    private lateinit var dataBase: RickAndMortyDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = this
        dataBase = RickAndMortyDatabase.getInstance(requireContext().applicationContext)

        repository = CharactersRepo(dataBase.rickAndMortyDao, RickAndMortyApi.retrofitService)

        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MainFragmentViewModel::class.java)

        viewModel.getAllCharacters()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CharacterAdapter(viewModel)

        viewModel.storage.observe(viewLifecycleOwner, Observer { newList ->
            adapter.submitList(newList)
        })
        
        binding.recyclerView.adapter = adapter
    }
}