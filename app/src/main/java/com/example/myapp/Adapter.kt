package com.example.myapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context, val list: ArrayList<DataModel>, val listener:DataModelItemClicked)
    :RecyclerView.Adapter<Adapter.ViewHolder>(){

//    private val inflater=context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val urlToImage: ImageView =view.findViewById(R.id.newsimage)
        val title: TextView =view.findViewById(R.id.newstest3)
        val description: TextView =view.findViewById(R.id.newstest4)
        val publishedAt: TextView =view.findViewById(R.id.newstest5)
        val timezone:TextView=view.findViewById(R.id.weathertext1)
        val id:TextView=view.findViewById(R.id.weathertext2)
        val name:TextView=view.findViewById(R.id.weathertex3)
        val cod:TextView=view.findViewById(R.id.weathertext4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val rowView=inflater.inflate(R.layout.newslist,parent,false)
        val rowView=LayoutInflater.from(parent.context).inflate(R.layout.newslist,parent,false)
        val viewHolder=ViewHolder(rowView)
        rowView.setOnClickListener {
            listener.DataModelItemClicked(list[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text= list.get(position).title
        holder.description.text=list.get(position).description
        holder.publishedAt.text=list.get(position).publishedAt
        holder.timezone.text=list.get(position).timezone
        holder.id.text=list.get(position).id
        holder.name.text=list.get(position).name
        holder.cod.text=list.get(position).cod
        context?.let {
            Glide.with(it)
                .load(list.get(position).urlToImage)
                .into(holder.urlToImage)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    interface DataModelItemClicked{
        fun DataModelItemClicked(list: DataModel)
    }
}