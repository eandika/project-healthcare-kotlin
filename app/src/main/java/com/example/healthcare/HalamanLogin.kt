package com.example.healthcare

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.healthcare.databinding.FragmentHalamanLoginBinding


class HalamanLogin : Fragment() {

    private lateinit var binding: FragmentHalamanLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_halaman_login, container, false)
        binding = FragmentHalamanLoginBinding.bind(view)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnTologin1.setOnClickListener {
            val intent = Intent(this@HalamanLogin.requireContext(), LoginActivity::class.java)
            startActivity(intent)

            Toast.makeText(context, "Halaman Login", Toast.LENGTH_SHORT).show()

        }

        binding.btnToreg1.setOnClickListener {
            val intent = Intent(this@HalamanLogin.requireContext(), RegisterActivity::class.java)
            startActivity(intent)

            Toast.makeText(context, "Halaman Register", Toast.LENGTH_SHORT).show()
        }
        return view
    }


}