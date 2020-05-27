package com.example.instituteofmining.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import at.blogc.android.views.ExpandableTextView
import com.example.instituteofmining.R
import com.example.instituteofmining.adapter.HomeSliderModel
import com.example.instituteofmining.adapter.home.HomeSliderAdapter
import com.example.instituteofmining.adapter.home.HomeSliderHolder
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getExpandableTextViewE(view)

        image_view_video.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/qxQT8nhnQ5A"))
            startActivity(browserIntent)
        }

        initViewPager()
//
    }

    var simpleRandom = Runnable {
        view_image_slider.setCurrentItem(view_image_slider.currentItem + 1)
    }

    private fun initViewPager(){
        val list: ArrayList<HomeSliderModel> = ArrayList()
        list.add(HomeSliderModel("http://itimm.ksmu.kg/wp-content/uploads/2019/06/IMG_0849.jpg"))
        list.add(HomeSliderModel("http://itimm.ksmu.kg/wp-content/uploads/2019/06/IMG_0850.jpg"))
        list.add(HomeSliderModel("http://itimm.ksmu.kg/wp-content/uploads/2019/06/IMG_0856.jpg"))
        list.add(HomeSliderModel("http://itimm.ksmu.kg/wp-content/uploads/2019/06/IMG_0861.jpg"))
        list.add(HomeSliderModel("http://itimm.ksmu.kg/wp-content/uploads/2019/06/IMG_0867.jpg"))
        list.add(HomeSliderModel("http://itimm.ksmu.kg/wp-content/uploads/2019/06/IMG_0870.jpg"))
        list.add(HomeSliderModel("http://itimm.ksmu.kg/wp-content/uploads/2019/06/IMG_0873.jpg"))
        list.add(HomeSliderModel("http://itimm.ksmu.kg/wp-content/uploads/2019/06/IMG_9778.jpg"))
        list.add(HomeSliderModel("http://itimm.ksmu.kg/wp-content/uploads/2019/06/IMG_0279.jpg"))
        list.add(HomeSliderModel("http://itimm.ksmu.kg/wp-content/uploads/2019/06/IMG_0846.jpg"))

        val adapters = HomeSliderAdapter()
        adapters.submitUpdate(list)
        view_image_slider.adapter = adapters

        view_image_slider.clipToPadding = false
        view_image_slider.clipChildren = false
        view_image_slider.offscreenPageLimit = 3
        view_image_slider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val composite = CompositePageTransformer()
        val margeTransform = MarginPageTransformer( 40)
        composite.addTransformer(margeTransform)
        composite.addTransformer { page, position ->
            val r: Float = 1 - Math.abs(position)
            page.scaleY = (0.85f + r * 0.15f)
        }
        view_image_slider.setPageTransformer(composite)

        view_image_slider.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val holder = Handler()
                holder.removeCallbacks(simpleRandom)
                holder.postDelayed(simpleRandom, 3000 )
            }
        })
    }

    private fun getExpandableTextViewE(view: View) {
        val expandableTextViewE = view.findViewById<ExpandableTextView>(R.id.home_title_name)
        expandableTextViewE.setAnimationDuration(5L)
        expandableTextViewE.setInterpolator(OvershootInterpolator())
        expandableTextViewE.setExpandInterpolator(OvershootInterpolator())
        expandableTextViewE.setCollapseInterpolator(OvershootInterpolator())
        expandableTextViewE.setOnClickListener(View.OnClickListener {
            expandableTextViewE.setText(if (expandableTextViewE.isExpanded()) R.string.short_description else R.string.home_full_description)
            expandableTextViewE.toggle()
        })
        expandableTextViewE.setOnClickListener(View.OnClickListener {
            if (expandableTextViewE.isExpanded()) {
                expandableTextViewE.collapse()
                expandableTextViewE.setText(R.string.home_full_description)
            } else {
                expandableTextViewE.expand()
                expandableTextViewE.setText(R.string.short_description)
            }
        })
    }
}
