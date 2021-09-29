package com.example.myapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class NewsViewActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_view)
        imageView=findViewById(R.id.newsimageview)
        textView1=findViewById(R.id.textview1)
        textView2=findViewById(R.id.textview2)
        textView3=findViewById(R.id.textview3)

        val screen1=intent.getStringExtra("text1")
        Log.d(TAG,"screen1"+screen1)
        val screen2=intent.getStringExtra("text2")
        Log.d(TAG,"screen2"+screen2)
        val screen3=intent.getStringExtra("text3")
        Log.d(TAG,"screen3"+screen3)
        val screen4=intent.getStringExtra("urlToImage")
        Log.d(TAG,"screen4"+screen4)

        textView1.text=screen1
        textView2.text=screen2
        textView3.text=screen3
        Glide.with(this)
            .load(screen4)
            .into(imageView)
//        context?.let {
//            Glide.with(it)
//                .load(list.get(position).urlToImage)
//                .into(holder.urlToImage)
//        }

    }
}