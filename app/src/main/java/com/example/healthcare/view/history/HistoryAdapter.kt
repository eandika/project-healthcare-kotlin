package com.example.healthcare.view.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.healthcare.R
import com.example.healthcare.model.ModelDatabase
import kotlinx.android.synthetic.main.list_item_history.view.*

class HistoryAdapter(var modelDatabase: MutableList<ModelDatabase>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    fun setDataAdapter(items: List<ModelDatabase>) {
        modelDatabase.clear()
        modelDatabase.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = modelDatabase[position]

        holder.tvDate.text = data.tanggal
        holder.tvJam.text = data.jam
        holder.tvNama.text = data.namaPasien
        holder.tvDokter.text = data.namaDokter
    }

    override fun getItemCount(): Int {
        return modelDatabase.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNama = itemView.tvNama
        var tvDate = itemView.tvDate
        var tvJam = itemView.tvJam
        var tvDokter = itemView.tvDokter
    }

    fun setSwipeRemove(position: Int): ModelDatabase {
        return modelDatabase.removeAt(position)
    }

}