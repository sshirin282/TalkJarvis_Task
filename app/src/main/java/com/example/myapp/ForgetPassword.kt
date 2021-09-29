package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgetPassword : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var textText: TextView
    lateinit var requestbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)
        email=findViewById(R.id.editemail)
        textText=findViewById(R.id.textview7)
        requestbutton=findViewById(R.id.request)
        requestbutton.setOnClickListener {
            val auth= FirebaseAuth.getInstance()
            auth.sendPasswordResetEmail(email.text.toString())
                .addOnCompleteListener { task->
                    if (task.isSuccessful){
                        Toast.makeText(this,"Successful", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"Failed", Toast.LENGTH_LONG).show()
                    }
                }

        }
    }
}