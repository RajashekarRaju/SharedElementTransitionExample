package com.developersbreach.sharedelementtransitionexample.bindingAdapters

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.sharedelementtransitionexample.list.ListFragmentDirections
import com.developersbreach.sharedelementtransitionexample.list.Sports
import com.developersbreach.sharedelementtransitionexample.list.SportsAdapter
import com.google.android.material.card.MaterialCardView


@BindingAdapter("bindListBanner")
fun ImageView.setListBanner(
    sports: Sports
) {
    this.setImageResource(sports.banner)
    this.transitionName = sports.banner.toString()
}


@BindingAdapter("bindContextReference")
fun RecyclerView.setRecyclerData(
    context: Context
) {
    val list = Sports.sportsList(context)
    val adapter = SportsAdapter()
    adapter.submitList(list)
    this.adapter = adapter
}


@BindingAdapter("bindItemClickListener", "bindBanner", "bindTitle")
fun MaterialCardView.setItemClickListener(
    sports: Sports,
    imageView: ImageView,
    textView: TextView
) {
    this.setOnClickListener {
        val direction: NavDirections =
            ListFragmentDirections.listToDetailFragment(sports)

        val extras = FragmentNavigatorExtras(
            imageView to sports.banner.toString(),
            textView to sports.title
        )

        findNavController().navigate(direction, extras)
    }
}
