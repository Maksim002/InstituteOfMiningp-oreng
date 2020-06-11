package com.example.instituteofmining.staff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.instituteofmining.R
import com.example.instituteofmining.adapter.description.DescriptionIncreaseAdapter
import com.example.instituteofmining.adapter.description.DescriptionRewardAdapter
import com.example.instituteofmining.adapter.model.EmployeeModel
import com.example.instituteofmining.adapter.model.NewEmployeeModel
import kotlinx.android.synthetic.main.fragment_description.*
import kotlin.collections.ArrayList

class DescriptionFragment : Fragment() {

    private var myIncreaseAdapter = DescriptionIncreaseAdapter()
    private var myReward = DescriptionRewardAdapter()

    var item = NewEmployeeModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initArguments()
        init()
        initRecyclerView()
    }

    private fun initRecyclerView() {

        if (this.item.list != null) {
            val lista = ArrayList<EmployeeModel>()
            this.item.list!!.forEach {
                if (it.beginning.isNotEmpty()|| it.topic.isNotEmpty()) {
                    lista.add(it)
                }
            }
            myReward.update(lista)
            description_reward_recycler.adapter = myReward

            myIncreaseAdapter.update(lista)
            description_increase_recycler.adapter = myIncreaseAdapter

            description_title_qualifications.visibility = View.VISIBLE
            description_title_rewards.visibility = View.VISIBLE
        } else {
            description_title_qualifications.visibility = View.GONE
            description_title_rewards.visibility = View.GONE
        }


    }

    private fun init() {
        description_title.setText(item.name + "" + item.surname + " " + item.patronymic)
        description_education.setText(item.education)
        description_graduated.setText(item.graduated)
        description_experience.setText(item.experience)
        description_degree.setText(item.degree)
        description_academic_title.setText(item.title)

        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))

        Glide
            .with(description_person.context)
            .load(item.person)
            .centerCrop()
            .apply(requestOptions)
            .into(description_person);
    }

    private fun initArguments() {
        item = try {
            arguments!!.getSerializable("item")
        } catch (e: Exception) {
            ""
        } as NewEmployeeModel
    }
}