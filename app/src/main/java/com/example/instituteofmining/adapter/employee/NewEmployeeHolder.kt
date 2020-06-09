package com.example.instituteofmining.adapter.employee

import android.app.DatePickerDialog
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.instituteofmining.adapter.model.EmployeeModel
import com.example.instituteofmining.utils.convertDate
import kotlinx.android.synthetic.main.item_new_employee.view.*
import java.util.*

class NewEmployeeHolder (itemView: View): RecyclerView.ViewHolder(itemView){

    fun bind(item: EmployeeModel) {

        itemView.order_date_from.onFocusChangeListener =
            View.OnFocusChangeListener { view: View?, b: Boolean ->
                    item.beginning = itemView.order_date_from.text.toString()
            }


        itemView.order_date_from.setOnTouchListener { _, event ->
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