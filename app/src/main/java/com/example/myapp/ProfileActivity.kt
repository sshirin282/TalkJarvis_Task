package com.example.myapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.log

class ProfileActivity : AppCompatActivity() {
    lateinit var textView1:TextView
    lateinit var textView2:TextView
    lateinit var textView3:TextView
    lateinit var logoutbutton:Button

    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        bottomNavigationView=findViewById(R.id.bottomnavigation3)
        textView1=findViewById(R.id.emailshow1)
        textView2=findViewById(R.id.emailshow2)
        textView3=findViewById(R.id.emailshow3)
        logoutbutton=findViewById(R.id.logoutbutton)

        val sharedPreferences: SharedPreferences =this.getSharedPreferences("USER", Context.MODE_PRIVATE)
        val sharevalue1=sharedPreferences.getString("username","")
//        val sharevalue2=sharedPreferences.getString("email","")
//        val sharevalue3=sharedPreferences.getString("phone","")
        if(sharevalue1.equals("")) {
            Log.e("username>>",sharevalue1+"")
        }else{
            textView1.setText(sharevalue1)
        }
//        if(sharevalue2.equals("")) {
//            Log.e("email>>",sharevalue2+"")
//        }else{
//            textView2.setText(sharevalue2)
//        }
//        if(sharevalue3.equals("")) {
//            Log.e("phone>>",sharevalue3+"")
//        }else{
//            textView3.setText(sharevalue3)
//        }
        logoutbutton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            true
        }

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


    }
}