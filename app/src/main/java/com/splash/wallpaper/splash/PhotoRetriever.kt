package com.splash.wallpaper.splash

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by lenovo on 1/26/2018.
 */
class PhotoRetriever {
    val BASE_URL = "https://pixabay.com/api/"
    private val service: PhotoApi

    init{
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(PhotoApi::class.java)
    }


    fun getPhotos(callback: Callback<PhotoList>){
        val call = service.getPhotos()
        call.enqueue(callback)
    }

}