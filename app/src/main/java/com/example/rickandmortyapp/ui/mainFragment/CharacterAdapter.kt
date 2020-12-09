package com.example.rickandmortyapp.ui.mainFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.FragmentListItemBinding
import com.example.rickandmortyapp.network.models.CharacterVO
import kotlinx.coroutines.*
import java.util.zip.Inflater

class CharacterAdapter(private val viewModel: MainFragmentViewModel): ListAdapter<CharacterVO, CharacterAdapter.CharacterHolder>(CharacterDiffCallBack()) {


    val job = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        return CharacterHolder.getViewHolder(parent, viewModel)
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.setValue(viewModel.storage.value!![position], position)
    }





    class CharacterHolder private constructor(
        private val binding: FragmentListItemBinding,
        private val viewModel: MainFragmentViewModel): RecyclerView.ViewHolder(binding.root) {


        fun setDefaultValue() {
            binding.nameTextView.text = "??????????"
            binding.imageView.setImageResource(R.drawable.ic_action_name)
        }

        fun setValue(characterVO: CharacterVO, pos: Int) {
            binding.nameTextView.text = characterVO.name
        }

            companion object {

                fun getViewHolder(parent: ViewGroup, viewModel: MainFragmentViewModel): CharacterHolder {
                    val inflater = LayoutInflater.from(parent.context)
                    val binding: FragmentListItemBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_item, parent, false)
                    return CharacterHolder(binding, viewModel)
                }

            }

        }


    class CharacterDiffCallBack: DiffUtil.ItemCallback<CharacterVO>() {
        override fun areItemsTheSame(oldItem: CharacterVO, newItem: CharacterVO): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: CharacterVO, newItem: CharacterVO): Boolean {
            return oldItem == newItem
        }
    }


}