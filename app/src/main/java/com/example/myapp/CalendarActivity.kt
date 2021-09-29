package com.example.myapp


import android.annotation.SuppressLint
import android.app.FragmentTransaction
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

class CalendarActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var textView:TextView
    lateinit var bottomNavigationView: BottomNavigationView
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        tabLayout=findViewById(R.id.tablayout)
        bottomNavigationView = findViewById(R.id.bottomnavigation3)
        textView=findViewById(R.id.calendartext)

        val sharedPreferences: SharedPreferences =this.getSharedPreferences("USER", Context.MODE_PRIVATE)
        val sharevalue=sharedPreferences.getString("email","")
        textView=findViewById(R.id.calendartext)
        if(sharevalue.equals("")) {
            Log.e("email>>",sharevalue+"")
        }else {
            textView.setText(sharevalue)
        }

        val fragment = ScannerFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction!!.replace(R.id.fragment2, fragment)
        fragmentTransaction!!.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction!!.commit()

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.calendar -> {
                    val intent = Intent(this, CalendarActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.profile->{
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                // creating cases for fragment
                when (tab.position) {
                    0 ->{
                        val fragment = ScannerFragment()
                        val fm = supportFragmentManager
                        val ft = fm.beginTransaction()
                        ft.replace(R.id.fragment2, fragment)
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        ft.commit()
                    }
                    1 ->{
                        val fragment = MakerFragment()
                        val fm = supportFragmentManager
                        val ft = fm.beginTransaction()
                        ft.replace(R.id.fragment2, fragment)
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        ft.commit()
                    }
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {
            }
            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })

    }
}
