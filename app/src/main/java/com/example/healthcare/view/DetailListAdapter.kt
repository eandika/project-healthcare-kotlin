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
import kotlinx.android.synthetic.main.detail_list.view.*

class DetailListAdapter(var photos: ArrayList<Photo>):
    RecyclerView.Adapter<DetailListAdapter.ViewHolder>() {

    fun updatePhotos(newPhotos: List<Photo>) {
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.detail_list, parent, false)
    )

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(photos: Photo){
            val detail : ImageView = itemView.imageview2
            val requestOp = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
            itemView.namadokter2.text = photos.name
            itemView.spesialis2.text = photos.specialist
            itemView.desc.text = photos.desc

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