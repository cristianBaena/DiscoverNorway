package com.example.discovernorway

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class PointsAdapter (private val pointsint: ArrayList<PointsInt>,private val mcontext: Context):
    RecyclerView.Adapter<PointsAdapter.PointHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_puntosinteres,parent,false)
        return PointHolder(view,mcontext)
    }

    override fun onBindViewHolder(holder: PointHolder, position: Int) {
        val poi = pointsint[position]
        holder.bind(poi)


    }
    override fun getItemCount(): Int = pointsint.size


    class PointHolder(itemView: View, private val mcontext: Context) : RecyclerView.ViewHolder(itemView){
        private var nameTextView:TextView =itemView.findViewById(R.id.tvName)
        private var descriptvView:TextView=itemView.findViewById(R.id.tvDescription)
        private var puntuacionView:TextView=itemView.findViewById(R.id.tvPunctuation)
        private var imageView: ImageView =itemView.findViewById(R.id.ivPuntoInt)



        fun bind(poi:PointsInt){
            nameTextView.text = poi.name
            descriptvView.text = poi.description
            poi.puntuacion.also { puntuacionView.text =it.toString()}
            Picasso.get().load(poi.urlImage).resize(150,180).centerCrop().into(imageView)

            itemView.setOnClickListener {
                val intent = Intent(mcontext, ActivityDetalle::class.java)
                intent.putExtra("rv",poi.name)
                intent.putExtra("rv1",poi.description)
                intent.putExtra("rv2",poi.puntuacion)
                intent.putExtra("rv3",poi.urlImage)
                mcontext.startActivity(intent)
            }



        }

    }

    }


