package com.example.discovernorway


import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    private  lateinit var listPois: ArrayList<PointsInt>
    private  lateinit var  poisAdapter: PointsAdapter
    private  lateinit var  poisrecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        poisrecyclerView=findViewById(R.id.rvPointOfInterest)

        listPois =loadMockPoisfromJson()
        poisAdapter= PointsAdapter(listPois, this)

        poisrecyclerView.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=poisAdapter
            setHasFixedSize(false)
        }

    }

    private fun loadMockPoisfromJson(): ArrayList<PointsInt> {
        val poisString: String =
            applicationContext.assets.open("puntos.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        return gson.fromJson(poisString, Poi::class.java)


    }


}