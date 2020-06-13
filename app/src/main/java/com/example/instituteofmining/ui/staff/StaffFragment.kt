package com.example.instituteofmining.ui.staff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.instituteofmining.R
import com.example.instituteofmining.adapter.model.NewEmployeeModel
import com.example.instituteofmining.adapter.staff.StaffAdapter
import com.example.instituteofmining.adapter.staff.StaffClickListener
import com.example.instituteofmining.main.MainActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_staff.*

class StaffFragment : Fragment(){
    private var myAdapter = StaffAdapter()
    private lateinit var myDatabase: DatabaseReference
    private val employee = "employee"
    private var list: ArrayList<NewEmployeeModel> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_staff, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addEmployee()
        initRecyclerView()
        getDtataFromDB()
    }

    private fun initRecyclerView(){
        staff_recycler.adapter = myAdapter
        myDatabase = FirebaseDatabase.getInstance().getReference(employee)
    }

    private fun getDtataFromDB(){
        MainActivity.alert.show()
        val vListener: ValueEventListener = object : ValueEventListener,
            StaffClickListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (list.size > 0) list.clear()
                list = ArrayList()
                for (data in dataSnapshot.children){
                    val employee = data.getValue(NewEmployeeModel::class.java)
                   if (data != null){
                       list.add(employee!!)
                       myAdapter.update(this, list)
                   }

                }
                myAdapter.notifyDataSetChanged()
                MainActivity.alert.hide()
            }
            override fun onCancelled(databaseError: DatabaseError) {}

            override fun onClickRequest(item: NewEmployeeModel) {
                val binder = Bundle()
                binder.putSerializable("item", item)
                findNavController().navigate(R.id.navigation_description, binder)
            }
        }
        myDatabase.addValueEventListener(vListener)
    }

    private fun addEmployee(){
        staff_add_employee.setOnClickListener {
            findNavController().navigate(R.id.navigation_new_employee)
        }
    }
}
