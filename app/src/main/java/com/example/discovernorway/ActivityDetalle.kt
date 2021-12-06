package com.example.discovernorway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ActivityDetalle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val namedetallepoi= this.intent.getStringExtra("rv")
        val namedetallepoitexview=findViewById<TextView>(R.id.Detalles)
        namedetallepoitexview.text=namedetallepoi

        val namedetallepoi1 = intent.getStringExtra("rv1")
        val namedetallepoitextview1=findViewById<TextView>(R.id.Detalles1)
        namedetallepoitextview1.text=namedetallepoi1

        val namedetallepoi2 = intent.getStringExtra("rv2")
        val namedetallepoitextview2=findViewById<TextView>(R.id.Detalles2)
        namedetallepoitextview2.text=namedetallepoi2

        val namedetallepoi3 = intent.getStringExtra("rv3")
        val namedetallepoitextview3=findViewById<ImageView>(R.id.Detalles3)
        Picasso.get().load(namedetallepoi3).into(namedetallepoitextview3)



    }
}