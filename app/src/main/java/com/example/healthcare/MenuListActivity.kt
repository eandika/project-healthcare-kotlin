package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.healthcare.*
import com.example.healthcare.databinding.ActivityMenuListBinding
import kotlinx.android.synthetic.main.activity_menu_list.*

class MenuListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuListBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    var dataArrayList = ArrayList<ListData?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_list)

        binding = ActivityMenuListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //custom ListView
        val nameList = arrayOf("drg. Nevada Permata Anvini", "drg. Alexander Bryan", "drg. Iwan", "drg. Sita Rose Nandiasa, M.Si", "dr. Hermawan, Sp.A", "dr. Melia Yunita, Sp.A.M.Sc", "dr. Dedy Lizal, Sp.JP", "dr. Sanny March Silaban, Sp.JP")
        val kompList = arrayOf("Spesialis Gigi Anak", "Spesialis Gigi", "Spesialis Gigi", "Spesialis Gigi", "Spesialis Anak", "Spesialis Anak", "Spesialis Jantung & Pembuluh Darah", "Spesialis Jantung & Pembuluh Darah")

        val imageList = intArrayOf(
            R.drawable.drg__nevada_permata_anvini,
            R.drawable.drg__alexander_bryan,
            R.drawable.drg__iwan,
            R.drawable.drg__sita_rose_nandiasa__m_si,
            R.drawable.dr__hermawan__sp_a,
            R.drawable.dr__melia_yunita__sp_a_m_sc,
            R.drawable.dr__dedy_lizal__sp_jp,
            R.drawable.dr__sanny_march_silaban__sp_jp
        )
        for (i in imageList.indices){
            listData = ListData(nameList[i], kompList[i], imageList[i])
            dataArrayList.add(listData)
        }

        listAdapter = ListAdapter(this@MenuListActivity, dataArrayList)
        binding.listview.adapter = listAdapter
        binding.listview.isClickable = true

        binding.listview.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@MenuListActivity, DetailedActivity::class.java)
            intent.putExtra("Name", nameList[i])
            intent.putExtra("Komp", kompList[i])
            intent.putExtra("image", imageList[i])
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

        binding.icArrowback.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}