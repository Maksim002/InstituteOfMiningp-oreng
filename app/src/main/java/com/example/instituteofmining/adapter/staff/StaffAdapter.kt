package com.example.instituteofmining.adapter.staff

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instituteofmining.R
import com.example.instituteofmining.adapter.model.NewEmployeeModel

class StaffAdapter(): RecyclerView.Adapter<StaffHolder>(){

    private lateinit var listener: StaffClickListener

    private var item: ArrayList<NewEmployeeModel> = arrayListOf()

    fun update(listener: StaffClickListener, list: ArrayList<NewEmployeeModel> = arrayListOf()){
        this.item = list
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffHolder {
        return StaffHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_staff, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: StaffHolder, position: Int) {
        holder.bind(item.get(position), listener)
    }

}