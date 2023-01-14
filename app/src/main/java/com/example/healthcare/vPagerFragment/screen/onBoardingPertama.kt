package com.example.healthcare.vPagerFragment.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.healthcare.R
import com.example.healthcare.databinding.FragmentOnBoardingPertamaBinding

class onBoardingPertama : Fragment() {

    private lateinit var binding: FragmentOnBoardingPertamaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_on_boarding_pertama, container, false)
        binding = FragmentOnBoardingPertamaBinding.bind(view)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnOnboardingNext1.setOnClickListener {
            viewPager?.currentItem = 1
        }
        return view
    }
}