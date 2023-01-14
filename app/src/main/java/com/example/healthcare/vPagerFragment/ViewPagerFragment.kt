package com.example.healthcare.vPagerFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthcare.R
import com.example.healthcare.databinding.FragmentViewPagerBinding
import com.example.healthcare.vPagerFragment.screen.onBoardingKedua
import com.example.healthcare.vPagerFragment.screen.onBoardingKetiga
import com.example.healthcare.vPagerFragment.screen.onBoardingPertama

class ViewPagerFragment : Fragment() {

    lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        binding = FragmentViewPagerBinding.bind(view)
        val fragmentList = arrayListOf(
            onBoardingPertama(),
            onBoardingKedua(),
            onBoardingKetiga()
        )
        val adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
        return view
    }
}