package com.example.myapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context, val list: ArrayList<DataModel>)
    :RecyclerView.Adapter<Adapter.ViewHolder>(){

    private val inflater=context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val urlToImage: ImageView =view.findViewById(R.id.newsimage)
        val title: TextView =view.findViewById(R.id.newstest3)
        val description: TextView =view.findViewById(R.id.newstest4)
        val publishedAt: TextView =view.findViewById(R.id.newstest5)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rowView=inflater.inflate(R.layout.newslist,parent,false)
        return ViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.title.text= currentItem.toString()
        holder.description.text=list.get(position).description
        holder.publishedAt.text=list.get(position).publishedAt
        context?.let {
            Glide.with(it)
                .load(list.get(position).urlToImage)
                .into(holder.urlToImage)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}