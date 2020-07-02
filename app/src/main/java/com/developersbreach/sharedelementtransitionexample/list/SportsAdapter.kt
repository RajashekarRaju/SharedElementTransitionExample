package com.developersbreach.sharedelementtransitionexample.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.sharedelementtransitionexample.databinding.ItemSportsBinding


class SportsAdapter : ListAdapter<Sports, SportsAdapter.SportsViewHolder>(DiffCallback) {

    class SportsViewHolder(
        private val binding: ItemSportsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            sports: Sports
        ) {
            binding.sports = sports
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSportsBinding.inflate(
            inflater, parent, false
        )
        return SportsViewHolder(binding)
    }

    object DiffCallback : DiffUtil.ItemCallback<Sports>() {

        override fun areItemsTheSame(
            oldItem: Sports,
            newItem: Sports
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: Sports,
            newItem: Sports
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}