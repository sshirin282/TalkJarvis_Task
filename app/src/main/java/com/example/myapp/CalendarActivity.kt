package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.google.android.material.bottomnavigation.BottomNavigationView

class CalendarActivity : AppCompatActivity() {
    lateinit var scanner: RadioButton
    lateinit var maker: RadioButton
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        scanner=findViewById(R.id.newsradio)
        maker=findViewById(R.id.weatherradio)
        bottomNavigationView=findViewById(R.id.bottomnavigation)


        scanner.setOnClickListener {
            val fragment=ScannerFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragment2,fragment).commit()
            true
        }
        maker.setOnClickListener {
            val fragment=MakerFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragment2,fragment).commit()
            true
        }

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->{
                    val intent= Intent(this,HomeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.calendar->{
                    val intent= Intent(this,CalendarActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }


    }
}