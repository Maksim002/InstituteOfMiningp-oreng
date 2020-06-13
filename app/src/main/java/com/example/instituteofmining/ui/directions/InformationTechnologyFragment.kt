package com.example.instituteofmining.ui.directions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.instituteofmining.R
import kotlinx.android.synthetic.main.fragment_information_technology.*

class InformationTechnologyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_information_technology, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(information_technologies.context)
            .load("https://www.kv.by/sites/default/files/styles/post_picture/public/pictures/userpictures/2019/02/08/2359/3a9d8b0af75004501e4be4339001c360.jpg?itok=Ph9dqdoj")
            .into(information_technologies)
    }
}