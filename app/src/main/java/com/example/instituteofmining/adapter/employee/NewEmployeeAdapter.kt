package com.example.instituteofmining.adapter.employee

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instituteofmining.R
import com.example.instituteofmining.adapter.model.NewEmployeeModel

class NewEmployeeAdapter : RecyclerView.Adapter<NewEmployeeHolder>(){

    private var item: ArrayList<NewEmployeeModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewEmployeeHolder {
        return NewEmployeeHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_new_employee, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: NewEmployeeHolder, position: Int) {
        holder.bind(item[position])
    }


}