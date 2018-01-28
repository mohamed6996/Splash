package com.splash.wallpaper.splash


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.flexbox.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    lateinit var photos: List<Photo>
    lateinit var recyclerView: RecyclerView
    var mainAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var retriever = PhotoRetriever()
        initDataSet(retriever)

    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_main, container, false)
        recyclerView = view.findViewById(R.id.recyclerview)
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
    }

    fun initRecyclerView() {

        // mainAdapter = MainAdapter(photos!!)
          recyclerView.layoutManager = GridLayoutManager(context,2)


        //  val layoutManager = FlexboxLayoutManager(context)
        //  layoutManager.flexDirection = FlexDirection.COLUMN
//        layoutManager.flexWrap = FlexWrap.WRAP
//        layoutManager.flexDirection = FlexDirection.ROW
//        layoutManager.alignItems = AlignItems.STRETCH
//        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = mainAdapter
    }

    fun initDataSet(retriever: PhotoRetriever) {
        val callback = object : Callback<PhotoList> {
            override fun onResponse(call: Call<PhotoList>?, response: Response<PhotoList>?) {
                response?.isSuccessful.let {
                    //// only run if isSuccessful returned a non null value
                    photos = response!!.body()!!.hits
                    mainAdapter = MainAdapter(photos!!)
                    recyclerView.adapter = mainAdapter
                    mainAdapter?.notifyDataSetChanged()
                    Toast.makeText(context, "photos${photos?.size}", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<PhotoList>?, t: Throwable?) {
                Toast.makeText(context, "Error retrieving the photos", Toast.LENGTH_LONG).show()
            }
        }

        retriever.getPhotos(callback)

    }
}
