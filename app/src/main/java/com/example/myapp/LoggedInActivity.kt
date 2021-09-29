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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LoggedInActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var forget: TextView
    lateinit var loginbutton: Button
    lateinit var signupbutton: Button
    lateinit var refUser: DatabaseReference
    var firebaseUserID: String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        forget = findViewById(R.id.textforget)
        loginbutton = findViewById(R.id.loginbutton)
        signupbutton = findViewById(R.id.singbutton)
        val sharedPreferences: SharedPreferences =this.getSharedPreferences("USER", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor=sharedPreferences.edit()
        forget.setOnClickListener {
            val intent = Intent(this, ForgetPassword::class.java)
            startActivity(intent)
        }
        signupbutton.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        val auth= FirebaseAuth.getInstance()

        loginbutton.setOnClickListener {
            if(email.text.toString().isEmpty() && password.text.toString().isEmpty()){
                email.setError("Please enter username ")
                password.setError("Please enter password")
            }else
                auth.signInWithEmailAndPassword(email.text.toString(),password.text.toString())
                    .addOnCompleteListener { task->
                        if (task.isSuccessful){
                            firebaseUserID = auth.currentUser!!.uid
                            refUser= FirebaseDatabase.getInstance().reference.child("shirin").child(firebaseUserID)
                            Log.e(VolleyLog.TAG,"Successfully signed in with email link")
                            val result=task.result
                            editor.putString("email",email.text.toString())
                            editor.putString("password",password.text.toString())
                            editor.apply()
                            editor.commit()
                            Toast.makeText(this,"Successful", Toast.LENGTH_LONG).show()
                            val intent= Intent(this, SplashScreen::class.java)
                            startActivity(intent)
                        }else{
                            Log.e(VolleyLog.TAG,"Error signing in with email link", task.exception)
                            Toast.makeText(this,"Please Enter Valid Username And Password", Toast.LENGTH_LONG).show()

                        }
                    }
        }
    }
}