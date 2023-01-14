package com.example.healthcare.vPagerFragment.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.healthcare.R
import com.example.healthcare.databinding.FragmentOnBoardingKeduaBinding

class onBoardingKedua : Fragment() {

    private lateinit var binding: FragmentOnBoardingKeduaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_on_boarding_kedua, container, false)
        binding = FragmentOnBoardingKeduaBinding.bind(view)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnOnboardingNext2.setOnClickListener {
            viewPager?.currentItem = 2
        }
        return view
    }
}