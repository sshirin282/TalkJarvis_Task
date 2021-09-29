package com.example.myapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.VolleyLog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class SignUp : AppCompatActivity() {
    lateinit var username: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var emailoptional: EditText
    lateinit var phone: EditText
    lateinit var textView81: TextView
    lateinit var signbutton: Button
    lateinit var loginbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val sharedPreferences: SharedPreferences =this.getSharedPreferences("USER", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor=sharedPreferences.edit()
        username=findViewById(R.id.username)
        email=findViewById(R.id.email)
        phone=findViewById(R.id.phone)
        password=findViewById(R.id.password1)
        emailoptional=findViewById(R.id.emailoptiona1)
        textView81=findViewById(R.id.signtext)
        signbutton=findViewById(R.id.signupbutton)
        loginbutton=findViewById(R.id.loginbutton)
        loginbutton.setOnClickListener {
            val intent= Intent(this,LoggedInActivity::class.java)
            startActivity(intent)
        }

    val auth= FirebaseAuth.getInstance()
    var  database = FirebaseDatabase.getInstance()
    signbutton.setOnClickListener {
        if(username.text.toString().isEmpty() && password.text.toString().isEmpty() && email.text.toString().isEmpty()  && phone.text.toString().isEmpty()) {
            username.setError("Please enter username")
            password.setError("Please enter password")
            email.setError("Please enter email")
            phone.setError("Please enter phone no")
        }else{
            auth.createUserWithEmailAndPassword(username.text.toString(),password.text.toString())
                .addOnCompleteListener { task->
                    if (task.isSuccessful){
                        storedata()
                        editor.putString("username",username.text.toString())
                        editor.putString("email",email.text.toString())
                        editor.putString("phone",phone.text.toString())
                        editor.apply()
                        editor.commit()
                        Log.e(VolleyLog.TAG,"Successfully signed in with email link")
                        Toast.makeText(this,"Successful", Toast.LENGTH_LONG).show()
                        val result=task.result
                    }else{

                        Log.e(VolleyLog.TAG,"Error signing in with email link",task.exception)
                        Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()
                    }
                }
        }

    }
}

    private fun storedata() {
        val model= DataModel1()
        model.username=username.text.toString()
        model.email=email.text.toString()
        model.password=password.text.toString()
        model.phone=phone.text.toString()
        model.emailoptional=emailoptional.text.toString()

        val sharedPreferences1: SharedPreferences =this.getSharedPreferences("USER", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor=sharedPreferences1.edit()

        val dp= FirebaseFirestore.getInstance()
        dp.collection("user").document(username.text.toString()).set(model).addOnSuccessListener {
            editor.putString("username",username.text.toString())
            editor.putString("email",email.text.toString())
            editor.putString("phone",phone.text.toString())
            editor.apply()
            editor.commit()
            Toast.makeText(this,"Suceessful",Toast.LENGTH_LONG).show()
        }
            .addOnFailureListener {
                Log.e(VolleyLog.TAG,"Error",it)
                Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
            }
    }
}