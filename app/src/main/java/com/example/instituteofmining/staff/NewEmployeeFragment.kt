package com.example.instituteofmining.staff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instituteofmining.R
import com.example.instituteofmining.adapter.employee.NewEmployeeAdapter
import com.example.instituteofmining.adapter.model.EmployeeModel
import com.example.instituteofmining.adapter.model.NewEmployeeModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_new_employee.*

class NewEmployeeFragment : Fragment() {
    private lateinit var myDatabase: DatabaseReference
    private val employee = "employee"
    private lateinit var adatapers: NewEmployeeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_employee, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initRecyclerView()
    }

    fun init(){
        myDatabase = FirebaseDatabase.getInstance().getReference(employee)

        button_add.setOnClickListener {
            val id = myDatabase.key.toString()
            val name = new_employee_name.text.toString()
            val surname = new_employee_surname.text.toString()
            val age = new_employee_age.text.toString()
            val myEmployee =
                NewEmployeeModel(
                    id,
                    name,
                    surname,
                    age
                )
            myDatabase.push().setValue(myEmployee)
        }
    }
    private fun initRecyclerView(){
        val adapters = NewEmployeeAdapter()
        val list: ArrayList<EmployeeModel> = ArrayList()
        list.add(EmployeeModel(1, "", "wdwd", "","","","",""))

        adapters.update(list)
        new_employee_recycler.adapter = adapters
    }
}