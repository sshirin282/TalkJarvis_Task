package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.gms.common.SignInButton

class MainActivity : AppCompatActivity() {
    lateinit var logoImage:ImageView
    lateinit var signInButton: SignInButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logoImage=findViewById(R.id.logoImage)
       signInButton=findViewById(R.id.google_button)
        signInButton.setOnClickListener {
            val intent=Intent(this,LoggedInActivity::class.java)
            startActivity(intent)
            true

        }
    }
}