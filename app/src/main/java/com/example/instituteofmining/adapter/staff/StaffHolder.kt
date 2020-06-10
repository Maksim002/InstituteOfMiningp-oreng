package com.example.instituteofmining.adapter.staff

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.instituteofmining.adapter.model.NewEmployeeModel
import kotlinx.android.synthetic.main.item_staff.view.*


class StaffHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    fun bind(item: NewEmployeeModel, listener: StaffClickListener) {
        itemView.staff_name.text = item.name + " " + item.surname + " " + item.patronymic

        itemView.setOnClickListener {
            listener.onClickRequest(item)
        }

        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))

        Glide
            .with(itemView.staff_person.context)
            .load(item.person)
            .centerCrop()
            .apply(requestOptions)
            .into(itemView.staff_person)
    }
}