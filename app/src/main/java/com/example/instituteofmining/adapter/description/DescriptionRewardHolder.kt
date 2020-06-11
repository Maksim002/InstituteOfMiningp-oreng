package com.example.instituteofmining.adapter.description

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.instituteofmining.adapter.model.EmployeeModel
import kotlinx.android.synthetic.main.item_description_reward.view.*

class DescriptionRewardHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind(get: EmployeeModel) {
        if (get != null){
            itemView.description_increase_reward.visibility = View.VISIBLE
            itemView.description_increase_issued.visibility = View.VISIBLE
            itemView.description_increase_issued_by_whom.visibility = View.VISIBLE
        }else{
            itemView.description_increase_reward.visibility = View.GONE
            itemView.description_increase_issued.visibility = View.GONE
            itemView.description_increase_issued_by_whom.visibility = View.GONE
        }

        itemView.description_increase_reward.text = get.reward
        itemView.description_increase_issued.text = get.issued
        itemView.description_increase_issued_by_whom.text = get.issued_by_whom
    }
}