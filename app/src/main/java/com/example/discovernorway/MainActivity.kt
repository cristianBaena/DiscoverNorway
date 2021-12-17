package com.example.discovernorway


import android.content.Intent
import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.discovernorway.data.api.ApiHelper
import com.example.discovernorway.data.api.RetrofitBuilder
import com.example.discovernorway.data.model.MainViewModel
import com.example.discovernorway.data.model.ViewModelFactory
import com.google.gson.Gson
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration


class MainActivity : AppCompatActivity() {
    private  lateinit var listPois: ArrayList<PointsInt>
    private  lateinit var  poisAdapter: PointsAdapter
    private  lateinit var  poisrecyclerView: RecyclerView
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupUI()
        poisrecyclerView=findViewById(R.id.rvPointOfInterest)

        listPois =loadMockPoisfromJson()
        poisAdapter= PointsAdapter(listPois, this)

        poisrecyclerView.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=poisAdapter
            setHasFixedSize(false)
        }


    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        poisrecyclerView=findViewById(R.id.rvPointOfInterest)
        poisrecyclerView.layoutManager = LinearLayoutManager(this)
        poisAdapter = PointsAdapter(arrayListOf(), this)
        poisrecyclerView.addItemDecoration(
            DividerItemDecoration(
                poisrecyclerView.context,
                (poisrecyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        poisrecyclerView.adapter = poisAdapter
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(R.id.settings == item.itemId){
            toSettings()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun toSettings() {
        val intent = Intent(this,SettingsActivity::class.java)
        startActivity(intent)

    }


    private fun loadMockPoisfromJson(): ArrayList<PointsInt> {
        val poisString: String =
//            Request.run {  }.toString()
            applicationContext.assets.open("db.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        return gson.fromJson(poisString, Poi::class.java)


    }


}