package com.example.instituteofmining.directions

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instituteofmining.R
import kotlinx.android.synthetic.main.fragment_directions.*


class DirectionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_directions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        direction_map.setOnClickListener {
            val url = "https://www.google.com/maps/dir/215+%D0%BF%D1%80%D0%BE%D1%81%D0%BF.+%D0%A7%D1%83%D0%B9,+%D0%91%D0%B8%D1%88%D0%BA%D0%B5%D0%BA/215+%D0%BF%D1%80%D0%BE%D1%81%D0%BF.+%D0%A7%D1%83%D0%B9,+%D0%91%D0%B8%D1%88%D0%BA%D0%B5%D0%BA/@42.8761934,74.5954493,18.5z/data=!4m13!4m12!1m5!1m1!1s0x389eb7dfb21a15d7:0x323e946070faa0ad!2m2!1d74.5957951!2d42.8764679!1m5!1m1!1s0x389eb7dfb21a15d7:0x323e946070faa0ad!2m2!1d74.5957951!2d42.8764679?hl=ru-RU"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        direction_call.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+996(312)612908")
            startActivity(intent)
        }
        direction_facebook.setOnClickListener {
            val url = "https://www.facebook.com/%D0%9A%D0%93%D0%93%D0%A3-%D0%B8%D0%BC%D0%B5%D0%BD%D0%B8-%D0%B0%D0%BA%D0%B0%D0%B4%D0%B5%D0%BC%D0%B8%D0%BA%D0%B0-%D0%A3%D1%81%D0%B5%D0%BD%D0%B3%D0%B0%D0%B7%D1%8B-%D0%90%D1%81%D0%B0%D0%BD%D0%B0%D0%BB%D0%B8%D0%B5%D0%B2%D0%B0-104439890899670/?modal=admin_todo_tour"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        direction_instagram.setOnClickListener {
            val url = "https://www.instagram.com/ksmu_igd/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }
}
