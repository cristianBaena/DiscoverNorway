package com.example.discovernorway


import android.content.Intent
import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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
            applicationContext.assets.open("db.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        return gson.fromJson(poisString, Poi::class.java)


    }


}