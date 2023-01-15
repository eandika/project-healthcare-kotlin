package com.example.healthcare.view.input

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.healthcare.*
import com.example.healthcare.databinding.ActivityInputDataBinding
import com.example.healthcare.viewmodel.InputDataViewModel
import kotlinx.android.synthetic.main.activity_input_data.*
import java.text.SimpleDateFormat
import java.util.*

class InputDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputDataBinding

    lateinit var inputDataViewModel: InputDataViewModel
    lateinit var sNama: String
    lateinit var sJk: String
    lateinit var sUsia: String
    lateinit var sDokter: String
    lateinit var sTanggal: String
    lateinit var sJam: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data)

        binding = ActivityInputDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setInitView()
        setViewModel()
        setSpinnerAdapter()
        setInputData()

        binding.icArrowback.setOnClickListener {
            val intent = Intent(this, DetailedActivity::class.java)
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
    }

    private fun setViewModel() {
        inputDataViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)).get(InputDataViewModel::class.java)
    }

    private fun setInitView() {
        inputTanggal.setOnClickListener { view: View? ->
            val tanggalTemu = Calendar.getInstance()
            val date = OnDateSetListener { view1: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                tanggalTemu[Calendar.YEAR] = year
                tanggalTemu[Calendar.MONTH] = monthOfYear
                tanggalTemu[Calendar.DAY_OF_MONTH] = dayOfMonth
                val strFormatDefault = "d MMMM yyyy"
                val simpleDateFormat = SimpleDateFormat(strFormatDefault, Locale.getDefault())
                inputTanggal.setText(simpleDateFormat.format(tanggalTemu.time))
            }
            DatePickerDialog(
                this@InputDataActivity, date,
                tanggalTemu[Calendar.YEAR],
                tanggalTemu[Calendar.MONTH],
                tanggalTemu[Calendar.DAY_OF_MONTH]
            ).show()
        }
    }

    private fun setSpinnerAdapter() {
        val adapterJk = ArrayAdapter.createFromResource(this, R.array.jenis_kelamin, android.R.layout.simple_spinner_dropdown_item)
        adapterJk.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_jk.adapter = adapterJk

        val adapterNmDokter = ArrayAdapter.createFromResource(this, R.array.nama_dokter, android.R.layout.simple_spinner_dropdown_item)
        adapterNmDokter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_namadokter.adapter = adapterNmDokter

        val adapterJam = ArrayAdapter.createFromResource(this, R.array.pilih_jam, android.R.layout.simple_spinner_dropdown_item)
        adapterJam.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_jam.adapter = adapterJam

        spinner_jk.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                sJk = parent.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        spinner_namadokter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                sDokter = parent.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        spinner_jam.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                sJam = parent.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun setInputData() {
        btn_book.setOnClickListener {
            sNama = input_name.text.toString()
            sUsia = input_umur.text.toString()
            sTanggal = inputTanggal.text.toString()

            if (sNama.isEmpty() || sJk.isEmpty() || sUsia.isEmpty()
                || sDokter.isEmpty() || sTanggal.isEmpty() || sJam.isEmpty()
            ) {
                Toast.makeText(this, "Mohon lengkapi data janji temu!", Toast.LENGTH_SHORT).show()
            }else {
                inputDataViewModel.addDataJanji(
                    sNama,
                    sJk,
                    sUsia,
                    sDokter,
                    sTanggal,
                    sJam
                )
                Toast.makeText(this,"Booking pertemuan berhasil, cek di menu riwayat", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}