package com.example.healthcare.vPagerFragment.screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.healthcare.R
import com.example.healthcare.databinding.FragmentOnBoardingKetigaBinding

class onBoardingKetiga : Fragment() {

    private lateinit var binding: FragmentOnBoardingKetigaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_on_boarding_ketiga, container, false)
        binding = FragmentOnBoardingKetigaBinding.bind(view)

        binding.btnOnboardingNext3.setOnClickListener {
            findNavController().navigate(
                R.id.action_viewPagerFragment_to_halamanLogin
            )
            onBoardingFinished()
        }
        return view
    }

    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("selesai", true)
        editor.apply()
    }
}