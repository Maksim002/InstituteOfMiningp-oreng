package com.example.instituteofmining.ui.entrant

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.instituteofmining.R
import kotlinx.android.synthetic.main.fragment_entrant.*


class EntrantFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_entrant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initExpandable()

        Glide
            .with(entrant_image.context)
            .load("https://static.gazeta.ua/img/cache/preview/687/687174_w_800.jpg")
            .into(entrant_image);

    }

    private fun initExpandable() {
        entrant_metallurgical.setAnimationDuration(50L)
        entrant_metallurgical.setInterpolator(OvershootInterpolator())
        entrant_metallurgical.setExpandInterpolator(OvershootInterpolator())
        entrant_metallurgical.setCollapseInterpolator(OvershootInterpolator())

        entrant_metallurgical.setOnClickListener {
            if (entrant_metallurgical.isExpanded()) {
                entrant_metallurgical.collapse()
                entrant_metallurgical.setText(R.string.entrant_expandable_2)
            } else {
                entrant_metallurgical.expand()
                entrant_metallurgical.setText(R.string.entrant_expandable_1)
            }
        }

        entrant_magistracy.setAnimationDuration(50L)
        entrant_magistracy.setInterpolator(OvershootInterpolator())
        entrant_magistracy.setExpandInterpolator(OvershootInterpolator())
        entrant_magistracy.setCollapseInterpolator(OvershootInterpolator())

        entrant_magistracy.setOnClickListener {
            if (entrant_magistracy.isExpanded()) {
                entrant_magistracy.collapse()
                entrant_magistracy.setText(R.string.entrant_expandable_5)
            } else {
                entrant_magistracy.expand()
                entrant_magistracy.setText(R.string.entrant_expandable_6)
            }
        }
    }
}