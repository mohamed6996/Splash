package com.splash.wallpaper.splash

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.squareup.picasso.Picasso


/**
 * Created by lenovo on 1/26/2018.
 */
class MainAdapter(var photos: List<Photo>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        var view: View = LayoutInflater.from(parent?.context).inflate(R.layout.photo_list_item, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        var photo: Photo
        photo = photos.get(position)
        Log.i("INFO", photo.webFormatUrl)
        if (photo.webFormatUrl.isNotEmpty()) {
            Picasso.with(holder?.itemView!!.context)
                    .load(photo.webFormatUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder?.photoItem);

        }
    }

    override fun getItemCount(): Int {
        return photos.size
    }


    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photoItem: ImageView

        init {
            photoItem = itemView.findViewById(R.id.recyclerview_photo)
        }
    }
}