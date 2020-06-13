package com.example.instituteofmining.ui.home


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.instituteofmining.R
import com.example.instituteofmining.adapter.model.HomeSliderModel
import com.example.instituteofmining.adapter.home.HomeSliderAdapter
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants.PlayerError
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

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

        initViewPager()
    }

    var simpleRandom = Runnable {

        try {
            if (view_image_slider.adapter!!.itemCount -1 == view_image_slider.currentItem) {
                view_image_slider.setCurrentItem(-1)
            } else {
                view_image_slider.setCurrentItem(view_image_slider.currentItem + 1)
            }

            println()
        } catch (e: Exception) {

        }

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

        view_image_slider.setUserInputEnabled(false);

        view_image_slider.clipToPadding = false
        view_image_slider.clipChildren = false
        view_image_slider.offscreenPageLimit = 3
        view_image_slider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val composite = CompositePageTransformer()
        val margeTransform = MarginPageTransformer(40)
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
                holder.postDelayed(simpleRandom, 6000)
            }
        })
    }

    override fun onStart() {
        super.onStart()
        initYoutube()

    }

    fun initYoutube() {

    }
}
