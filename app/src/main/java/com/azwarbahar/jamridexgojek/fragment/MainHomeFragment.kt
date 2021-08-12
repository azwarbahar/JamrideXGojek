package com.azwarbahar.jamridexgojek.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.azwarbahar.jamridexgojek.R
import com.azwarbahar.jamridexgojek.SliderEdukasiItem
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import kotlinx.android.synthetic.main.fragment_main_home.*


class MainHomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val rootView = inflater.inflate(R.layout.fragment_main_home, container, false)
        val imageList = ArrayList<SlideModel>()
        // Create image list
        imageList.add(SlideModel(R.drawable.img_slide1))
        imageList.add(SlideModel(R.drawable.img_slide2))
        imageList.add(SlideModel(R.drawable.img_slide3))

        val imageSlider = rootView.findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)

        return rootView
    }
}

