package com.example.instituteofmining.ui.home


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instituteofmining.R
import com.example.instituteofmining.adapter.home.HomeSliderAdapter
import com.example.instituteofmining.adapter.model.HomeSliderModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants.PlayerError
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlinx.android.synthetic.main.fragment_home.*
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : Fragment() {
    private var timer = Timer()
    private lateinit var yotube: YouTubePlayerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        yotube = view.findViewById(R.id.youtube_player_view)

        yotube.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onError(youTubePlayer: YouTubePlayer, error: PlayerError) {
                super.onError(youTubePlayer, error)
                youTubePlayer.loadVideo("qxQT8nhnQ5A", 0f)
            }
        })
    }

    private fun initViewPager() {
        val list: ArrayList<HomeSliderModel> = ArrayList()
        list.add(HomeSliderModel("http://ksmu.kg/wp-content/uploads/2019/06/444444.jpg"))
        list.add(HomeSliderModel("http://ksmu.kg/wp-content/uploads/2019/06/45454545.jpg"))
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

        val speedScroll = 5000
        val handler = Handler()
        val runnable: Runnable = object : Runnable {
            var count = 0
            var flag = true
            override fun run() {
                if (count < adapters.getItemCount()) {
                    if (count == adapters.getItemCount() - 1) {
                        flag = false
                    } else if (count == 0) {
                        flag = true
                    }
                    if (flag) count++ else count--
                    try {
                        view_image_slider.smoothScrollToPosition(count)
                    }catch (e: Exception){}
                    handler.postDelayed(this, speedScroll.toLong())
                }
            }
        }

        handler.postDelayed(runnable, speedScroll.toLong())
    }

    override fun onStart() {
        super.onStart()
        initYoutube()
        initViewPager()
    }

    override fun onStop() {
        super.onStop()
        timer.cancel()
    }

    fun initYoutube() {

    }
}
