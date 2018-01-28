package com.splash.wallpaper.splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
//    override fun onClick(p0: View?) {
//        Toast.makeText(this@MainActivity, "hi", Toast.LENGTH_SHORT).show()
//    }

//    var photos: List<Photo>? = null
//    lateinit var recyclerView: RecyclerView
//    var mainAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        recyclerView = findViewById(R.id.recyclerview)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        var retriever = PhotoRetriever()
//
//        val callback = object : Callback<PhotoList> {
//            override fun onResponse(call: Call<PhotoList>?, response: Response<PhotoList>?) {
//                response?.isSuccessful.let {
//                    //// only run if isSuccessful returned a non null value
//                    photos = response?.body()?.hits
//                    mainAdapter = MainAdapter(photos!!, this@MainActivity)
//                    recyclerView.adapter = mainAdapter
//                    mainAdapter?.notifyDataSetChanged()
//                    Toast.makeText(this@MainActivity, "photos${photos?.size}", Toast.LENGTH_LONG).show()
//                    //  val imageUrl = photos?.get(1)?.webFormatUrl
//                    //  Glide.with(this@MainActivity).load(imageUrl).into(imageview)
//                }
//            }
//
//            override fun onFailure(call: Call<PhotoList>?, t: Throwable?) {
//                Toast.makeText(this@MainActivity, "Error retrieving the photos", Toast.LENGTH_LONG).show()
//            }
//        }
//
//        retriever.getPhotos(callback)
    }
}
