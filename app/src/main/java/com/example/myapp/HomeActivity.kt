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
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

     lateinit var tabLayout: TabLayout
     lateinit var textView:TextView
    lateinit var bottomNavigationView: BottomNavigationView
    @SuppressLint("WrongConstant", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val sharedPreferences1: SharedPreferences =this.getSharedPreferences("USER", Context.MODE_PRIVATE)
        val sharevalue1=sharedPreferences1.getString("username","")
        textView=findViewById(R.id.hometext)
        if(sharevalue1.equals("")) {
            Log.e("email>>",sharevalue1+"")
        }else {
            textView.setText(sharevalue1)
        }

//        title=resources.getString(R.id.home)
//        loadFragment(NewsFragment())


        tabLayout=findViewById(R.id.tablayout)
        bottomNavigationView=findViewById(R.id.bottomnavigation)

        val fragment = NewsFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction!!.replace(R.id.fragment, fragment)
        fragmentTransaction!!.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction!!.commit()



        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->{
//                    title=resources.getString(R.id.home)
//                    loadFragment(NewsFragment())
                    val intent=Intent(this,HomeActivity::class.java)
                    intent.putExtra("fragment","Home")
                    startActivity(intent)
                    true
                }
                R.id.calendar->{
                    val intent=Intent(this,CalendarActivity::class.java)
                    intent.putExtra("fragment","Calendar")
                    startActivity(intent)
                  true
                }
                R.id.profile->{
                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("fragment","Profile")
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 ->{
                        val fragment = NewsFragment()
                        val fm = supportFragmentManager
                        val ft = fm.beginTransaction()
                        ft.replace(R.id.fragment, fragment)
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        ft.commit()
                    }
                    1 ->{
                        val fragment = WeatherFragment()
                        val fm = supportFragmentManager
                        val ft = fm.beginTransaction()
                        ft.replace(R.id.fragment, fragment)
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



