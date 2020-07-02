package com.developersbreach.sharedelementtransitionexample.bindingAdapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.developersbreach.sharedelementtransitionexample.list.Sports

@BindingAdapter("bindDetailBanner")
fun ImageView.setDetailBanner(
    sports: Sports
) {
    this.setImageResource(sports.banner)
    this.transitionName = sports.banner.toString()
}