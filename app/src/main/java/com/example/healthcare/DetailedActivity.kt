package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.healthcare.databinding.ActivityDetailedBinding
import com.example.healthcare.view.input.InputDataActivity

class DetailedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = this.intent
        if (intent != null){
            val name = intent.getStringExtra("Name")
            val komp = intent.getStringExtra("Komp")
            val image = intent.getIntExtra("image", R.drawable.drg__nevada_permata_anvini)

            binding.detailName.text = name
            binding.detailKomp.text = komp
            binding.detailImage.setImageResource(image)
        }

        binding.icArrowback.setOnClickListener {
            val intent = Intent(this, MenuListActivity::class.java)
            startActivity(intent)
        }

        binding.btnBooknow.setOnClickListener {
            val intent = Intent(this, InputDataActivity::class.java)
            startActivity(intent)
        }
    }
}