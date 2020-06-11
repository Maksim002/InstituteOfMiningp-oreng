package com.example.instituteofmining.adapter.description

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instituteofmining.R
import com.example.instituteofmining.adapter.model.EmployeeModel

class DescriptionIncreaseAdapter: RecyclerView.Adapter<DescriptionIncreaseViewHolder>(){

    private var list: ArrayList<EmployeeModel> = arrayListOf()

    fun update(list: ArrayList<EmployeeModel>){
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionIncreaseViewHolder {
        return DescriptionIncreaseViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_increase_description, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holderIncrease: DescriptionIncreaseViewHolder, position: Int) {
        holderIncrease.bind(list.get(position))
    }

}