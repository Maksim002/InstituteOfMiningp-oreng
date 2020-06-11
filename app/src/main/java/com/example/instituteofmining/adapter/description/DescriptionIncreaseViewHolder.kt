package com.example.instituteofmining.adapter.description

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.instituteofmining.adapter.model.EmployeeModel
import kotlinx.android.synthetic.main.item_increase_description.view.*

class DescriptionIncreaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(get: EmployeeModel) {
            if (get != null) {
                itemView.description_increase_beginning.visibility = View.VISIBLE
                itemView.description_increase_ending.visibility = View.VISIBLE
                itemView.description_increase_type_of_qualification.visibility = View.VISIBLE
                itemView.description_increase_certificate.visibility = View.VISIBLE
                itemView.description_increase_laboriousness.visibility = View.VISIBLE
                itemView.description_increase_venue.visibility = View.VISIBLE
                itemView.description_increase_topic.visibility = View.VISIBLE
            } else {
                itemView.description_increase_beginning.visibility = View.GONE
                itemView.description_increase_ending.visibility = View.GONE
                itemView.description_increase_type_of_qualification.visibility = View.GONE
                itemView.description_increase_certificate.visibility = View.GONE
                itemView.description_increase_laboriousness.visibility = View.GONE
                itemView.description_increase_venue.visibility = View.GONE
                itemView.description_increase_topic.visibility = View.GONE
            }

        itemView.description_increase_beginning.text = get.beginning
        itemView.description_increase_ending.text = get.ending
        itemView.description_increase_type_of_qualification.text = get.type_of_qualification
        itemView.description_increase_certificate.text = get.certificate
        itemView.description_increase_laboriousness.text = get.laboriousness
        itemView.description_increase_venue.text = get.venue
        itemView.description_increase_topic.text = get.topic
    }
}