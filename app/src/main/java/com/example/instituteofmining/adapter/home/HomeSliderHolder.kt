package com.example.instituteofmining.adapter.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instituteofmining.adapter.HomeSliderModel
import kotlinx.android.synthetic.main.item_image_slade.view.*

class HomeSliderHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    var slidetImage = itemView.image_slide

    fun bind(get: HomeSliderModel) {

        Glide.with(slidetImage.context)
            .load(get.image)
            .into(slidetImage)
    }
}
