package com.example.instituteofmining.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instituteofmining.R
import com.example.instituteofmining.adapter.model.HomeSliderModel

class HomeSliderAdapter: RecyclerView.Adapter<HomeSliderHolder>(){

    private var item: ArrayList<HomeSliderModel> = ArrayList()

    fun submitUpdate(list: ArrayList<HomeSliderModel>){
        item = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeSliderHolder {
        return HomeSliderHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_image_slade,parent, false)
        )
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: HomeSliderHolder, position: Int) {
        holder.bind(item.get(position))
    }
}