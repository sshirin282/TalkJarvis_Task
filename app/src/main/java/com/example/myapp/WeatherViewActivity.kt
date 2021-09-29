package com.example.myapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class WeatherViewActivity : AppCompatActivity() {
    lateinit var weather1: TextView
    lateinit var weather2: TextView
    lateinit var weather3: TextView
    lateinit var weather4: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_view)
        weather1=findViewById(R.id.weather1)
        weather2=findViewById(R.id.weather2)
        weather3=findViewById(R.id.weather3)
        weather4=findViewById(R.id.weather4)

        val screen11=intent.getStringExtra("weather1")
        Log.d(ContentValues.TAG,"screen1"+screen11)
        val screen12=intent.getStringExtra("weather2")
        Log.d(ContentValues.TAG,"screen2"+screen12)
        val screen13=intent.getStringExtra("weather3")
        Log.d(ContentValues.TAG,"screen3"+screen13)
        val screen14=intent.getStringExtra("weather4")
        Log.d(ContentValues.TAG,"screen4"+screen14)
        weather1.text=screen11
        weather2.text=screen12
        weather3.text=screen13
        weather4.text=screen14

    }
}