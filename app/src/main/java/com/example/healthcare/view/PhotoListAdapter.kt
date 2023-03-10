package com.example.healthcare.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.healthcare.DetailedActivity
import com.example.healthcare.R
import com.example.healthcare.model.Photo
import com.example.healthcare.viewmodel.DetailActivity
import kotlinx.android.synthetic.main.item_list.view.*

class PhotoListAdapter(var photos: ArrayList<Photo>):
    RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {

    fun updatePhotos(newPhotos: List<Photo>) {
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
    )

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(photos: Photo){
            val detail :ImageView = itemView.imageview
            val requestOp = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
            itemView.namadokter.text = photos.name
            itemView.spesialis.text = photos.specialist
            itemView.setOnClickListener { view ->
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra("detailName", photos.name)
                intent.putExtra("detailImage", photos.image_url)
                intent.putExtra("detailKomp", photos.desc)
                itemView.context.startActivity(intent)
            }

            val alamaturl = photos.image_url.toString().filterNot {
                it.isWhitespace()
            }
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOp)
                .load("$alamaturl.png")
                .into(detail)
        }
    }
}