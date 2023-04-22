package com.example.parcial2_19812.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2_19812.PerfilActivity
import com.example.parcial2_19812.R

class ImageAdapter(private val images: List<Int>, private val texts: Array<String>, private val activity: Activity) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.ivMenu)
        val text: TextView = itemView.findViewById(R.id.tvOpcion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = images[position]
        val text = texts[position]
        holder.image.setImageResource(image)
        holder.image.layoutParams.width = 600
        holder.image.layoutParams.height = 600
        holder.text.setText(text)



        if (position == 3) {
            holder.image.setOnClickListener {
                activity.finish()
            }
        }

        if (position == 1) {
            holder.image.setOnClickListener {
                val intent = Intent(holder.itemView.context, PerfilActivity::class.java)
                holder.itemView.context.startActivity(intent)
            }
        }

    }

    override fun getItemCount(): Int {
        return images.size
    }


}
