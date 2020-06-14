package com.example.instituteofmining.ui.life

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.instituteofmining.R
import kotlinx.android.synthetic.main.fragment_life.*

class LifeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_life, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        life_map.setOnClickListener {
            val url = "https://www.google.com/maps/place/175+%D1%83%D0%BB.+%D0%90%D1%85%D1%83%D0%BD%D0%B1%D0%B0%D0%B5%D0%B2%D0%B0,+%D0%91%D0%B8%D1%88%D0%BA%D0%B5%D0%BA/@42.8437615,74.5855595,17z/data=!3m1!4b1!4m5!3m4!1s0x389ec9deae73f73f:0x755900b4381c3e5f!8m2!3d42.8437576!4d74.5877482?hl=ru-KG"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }
}
