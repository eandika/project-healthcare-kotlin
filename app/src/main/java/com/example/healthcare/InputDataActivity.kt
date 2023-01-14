package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import com.example.healthcare.databinding.ActivityInputDataBinding
import kotlinx.android.synthetic.main.activity_input_data.*
import java.util.Calendar

class InputDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data)

        binding = ActivityInputDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icArrowback.setOnClickListener {
            val intent = Intent(this, DetailedActivity::class.java)
            startActivity(intent)
        }

        binding.btnBook.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        binding.profilePage.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        binding.searchPage.setOnClickListener {
            val intent = Intent(this, MenuListActivity::class.java)
            startActivity(intent)
        }

        binding.homePage.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        val adapter = ArrayAdapter.createFromResource(this, R.array.jenis_kelamin, android.R.layout.simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_jk.adapter = adapter

        val adapter2 = ArrayAdapter.createFromResource(this, R.array.nama_dokter, android.R.layout.simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_namadokter.adapter = adapter2

        val datePicker = findViewById<DatePicker>(R.id.date_picker)
        val today = Calendar.getInstance()
        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)) {
            view, year, month, day ->
            val month = month + 1
            val msg = "Memilih: $day/$month/$year"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        val adapter3 = ArrayAdapter.createFromResource(this, R.array.pilih_jam, android.R.layout.simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_jam.adapter = adapter3
    }
}