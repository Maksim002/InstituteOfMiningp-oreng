package com.example.instituteofmining.adapter.description

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instituteofmining.R
import com.example.instituteofmining.adapter.model.EmployeeModel

class DescriptionRewardAdapter : RecyclerView.Adapter<DescriptionRewardHolder>(){

    private var item: ArrayList<EmployeeModel> = arrayListOf()

    fun update(list:ArrayList<EmployeeModel>){
        this.item = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionRewardHolder {
        return DescriptionRewardHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_description_reward, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: DescriptionRewardHolder, position: Int) {
        holder.bind(item.get(position))
    }

}