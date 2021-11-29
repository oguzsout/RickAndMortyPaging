package com.oguzdogdu.rickandmortypaging.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.oguzdogdu.rickandmortypaging.databinding.CharacterLayoutBinding
import com.oguzdogdu.rickandmortypaging.model.RickMortyModel
import javax.inject.Inject

class RickMortyAdapter @Inject constructor() :
    PagingDataAdapter<RickMortyModel, RickMortyAdapter.ImageViewHolder>(diffCallback) {

    inner class ImageViewHolder(private val binding: CharacterLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(rickMortyModel: RickMortyModel) {
            binding.apply {
                tvDescription.text = rickMortyModel.name
                val imageLink = rickMortyModel.image
                imageView.load(imageLink) {
                    crossfade(true)
                    crossfade(1000)
                }
            }
        }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<RickMortyModel>() {
            override fun areItemsTheSame(
                oldItem: RickMortyModel,
                newItem: RickMortyModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: RickMortyModel,
                newItem: RickMortyModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            CharacterLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currChar = getItem(position)

        if (currChar != null) {
            holder.bind(currChar)
        }
    }
}







       /* holder.binding.root.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(currChar!!)
            Navigation.findNavController(it).navigate(action)
        }
    }

        */



