package com.example.rickandmortyapp.ui.mainFragment

import android.graphics.Color
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
        return CharacterHolder.getViewHolder(parent, viewModel, CharacterVO())
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.setValue(viewModel.storage.value!![position], position)
    }





    class CharacterHolder private constructor(
        private val binding: FragmentListItemBinding,
        private val viewModel: MainFragmentViewModel,
        private val characterVO: CharacterVO): RecyclerView.ViewHolder(binding.root) {


        init {
            binding.character = characterVO
            binding.executePendingBindings()
        }

        fun setDefaultValue() {
            binding.nameTextView.text = "??????????"
            binding.imageView.setImageResource(R.drawable.ic_action_name)
        }

        private fun setStatus(characterVO: CharacterVO) {
            binding.statusTextView.text = characterVO.status

            when(characterVO.status) {
                Statuses.ALIVE.string -> binding.statusTextView.setTextColor(Color.GREEN)
                Statuses.DEAD.string -> binding.statusTextView.setTextColor(Color.RED)
                else -> binding.statusLabel.setTextColor(Color.BLACK)
            }
        }

        fun setValue(characterVO: CharacterVO, pos: Int) {
            binding.nameTextView.text = characterVO.name
            binding.character = characterVO

            setStatus(characterVO)

            binding.executePendingBindings()
        }

            companion object {

                fun getViewHolder(parent: ViewGroup, viewModel: MainFragmentViewModel, characterVO: CharacterVO): CharacterHolder {
                    val inflater = LayoutInflater.from(parent.context)
                    val binding: FragmentListItemBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_item, parent, false)
                    return CharacterHolder(binding, viewModel, characterVO)
                }

            }

        enum class Statuses(val string: String) {
            ALIVE("Alive"), DEAD("Dead"), UNKNOWN("Unknown")
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