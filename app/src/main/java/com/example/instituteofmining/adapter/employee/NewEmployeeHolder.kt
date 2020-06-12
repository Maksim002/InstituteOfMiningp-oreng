package com.example.instituteofmining.adapter.employee

import android.app.DatePickerDialog
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.instituteofmining.adapter.model.EmployeeModel
import com.example.instituteofmining.utils.convertDate
import kotlinx.android.synthetic.main.item_new_employee.view.*
import java.util.*


class NewEmployeeHolder (itemView: View): RecyclerView.ViewHolder(itemView){

    fun bind(item: EmployeeModel, listener: NewClickListener) {

        itemView.order_date_from.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                listener.onNewClickListener()
            }
        }

        itemView.order_date_to.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                listener.onNewClickListener()
            }
        }

        itemView.order_date_issued.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                listener.onNewClickListener()
            }
        }

        itemView.profile_name.addTextChangedListener ( object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                try {
                    item.type_of_qualification = itemView.profile_name.text.toString()
                }catch (e: Exception){

                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })


        itemView.order_date_from.addTextChangedListener ( object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                try {
                    item.beginning = itemView.order_date_from.text.toString()
                }catch (e: Exception){

                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        itemView.order_date_to.addTextChangedListener ( object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                try {
                    item.ending = itemView.order_date_to.text.toString()
                }catch (e: Exception){

                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        itemView.profile_topic.addTextChangedListener ( object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                try {
                    item.topic = itemView.profile_topic.text.toString()
                }catch (e: Exception){

                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        itemView.profile_laboriousness.addTextChangedListener ( object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                try {
                    item.laboriousness = itemView.profile_laboriousness.text.toString()
                }catch (e: Exception){

                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        itemView.profile_venue.addTextChangedListener ( object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                try {
                    item.venue = itemView.profile_venue.text.toString()
                }catch (e: Exception){

                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        itemView.profile_certificate.addTextChangedListener ( object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                try {
                    item.certificate = itemView.profile_certificate.text.toString()
                }catch (e: Exception){

                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        itemView.profile_reward.addTextChangedListener ( object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                try {
                    item.reward = itemView.profile_reward.text.toString()
                }catch (e: Exception){

                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        itemView.profile_issued_by_whom.addTextChangedListener ( object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                try {
                    item.issued_by_whom = itemView.profile_issued_by_whom.text.toString()
                }catch (e: Exception){

                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        itemView.order_date_issued.addTextChangedListener ( object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                try {
                    item.issued = itemView.order_date_issued.text.toString()
                }catch (e: Exception){

                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        itemView.order_date_from.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_UP) {

                val calendar: Calendar = Calendar.getInstance(TimeZone.getDefault())

                val dialog = DatePickerDialog(
                    itemView.context, null,
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                )

                dialog.setOnDateSetListener { _, year, month, dayOfMonth ->
                   itemView.order_date_from.setText(convertDate(dayOfMonth, month + 1, year))
                }
                dialog.show()

            }
            false
        }

        itemView.order_date_to.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val calendar: Calendar = Calendar.getInstance(TimeZone.getDefault())

                val dialog = DatePickerDialog(
                    itemView.context, null,
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                )

                dialog.setOnDateSetListener { _, year, month, dayOfMonth ->
                    itemView.order_date_to.setText(convertDate(dayOfMonth, month + 1, year))
                }
                dialog.show()

            }
            false
        }

        itemView.order_date_issued.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val calendar: Calendar = Calendar.getInstance(TimeZone.getDefault())

                val dialog = DatePickerDialog(
                    itemView.context, null,
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                )

                dialog.setOnDateSetListener { _, year, month, dayOfMonth ->
                    itemView.order_date_issued.setText(convertDate(dayOfMonth, month + 1, year))
                }
                dialog.show()

            }
            false
        }
    }
}