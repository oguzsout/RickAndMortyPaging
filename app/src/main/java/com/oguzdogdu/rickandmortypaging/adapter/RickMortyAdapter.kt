package com.oguzdogdu.rickandmortypaging.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.oguzdogdu.rickandmortypaging.databinding.CharacterLayoutBinding
import com.oguzdogdu.rickandmortypaging.model.RickMortyModel

class RickMortyAdapter : PagingDataAdapter<RickMortyModel,
        RickMortyAdapter.ImageViewHolder>(diffCallback) {


    inner class ImageViewHolder(
        val binding: CharacterLayoutBinding
    ) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<RickMortyModel>() {
            override fun areItemsTheSame(oldItem: RickMortyModel, newItem: RickMortyModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: RickMortyModel, newItem: RickMortyModel): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            CharacterLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currChar = getItem(position)

        holder.binding.apply {

            holder.itemView.apply {
                tvDescription.text = "${currChar?.name}"

                val imageLink = currChar?.image
                imageView.load(imageLink) {
                    crossfade(true)
                    crossfade(1000)
                }
            }
        }

    }


}