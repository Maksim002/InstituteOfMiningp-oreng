package com.example.instituteofmining.staff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.instituteofmining.R
import kotlinx.android.synthetic.main.fragment_staff.*

class StaffFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_staff, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addEmployee()
    }

    private fun addEmployee(){
        staff_add_employee.setOnClickListener {
            findNavController().navigate(R.id.navigation_new_employee)
        }
    }
}
