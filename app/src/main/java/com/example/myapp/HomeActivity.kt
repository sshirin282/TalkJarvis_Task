package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var newaradio:RadioButton
    lateinit var weatherradio:RadioButton
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        newaradio=findViewById(R.id.newsradio)
        weatherradio=findViewById(R.id.weatherradio)
        bottomNavigationView=findViewById(R.id.bottomnavigation)
//        val fragment=NewsFragment()
//        supportFragmentManager.beginTransaction().replace(R.id.fragment,fragment).commit()
//        true

        newaradio.setOnClickListener {
            val fragment=NewsFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragment,fragment).commit()
            true
        }
        weatherradio.setOnClickListener {
            val fragment=WeatherFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragment,fragment).commit()
            true
        }

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->{
                    val intent=Intent(this,HomeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.calendar->{
                    val intent=Intent(this,CalendarActivity::class.java)
                    startActivity(intent)
                  true
                }
                else -> false
            }
        }


    }
}