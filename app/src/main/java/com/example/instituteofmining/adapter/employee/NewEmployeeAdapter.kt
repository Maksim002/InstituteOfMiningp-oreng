package com.example.instituteofmining.adapter.employee

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instituteofmining.R
import com.example.instituteofmining.adapter.model.EmployeeModel
import com.example.instituteofmining.staff.NewEmployeeFragment
import kotlinx.android.synthetic.main.item_new_employee.view.*

class NewEmployeeAdapter : RecyclerView.Adapter<NewEmployeeHolder>() {

    private var item: ArrayList<EmployeeModel> = ArrayList()

    fun getBookingRoomModels(): ArrayList<EmployeeModel> {
        return item
    }

    fun delete(position: EmployeeModel){
        item.remove(position)
        notifyDataSetChanged()
    }

    fun update(list: ArrayList<EmployeeModel>) {
        this.item = list
        notifyDataSetChanged()
    }

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

        holder.itemView.new_employee_clear.setOnClickListener {
            delete(item.get(position))
        }
    }
}