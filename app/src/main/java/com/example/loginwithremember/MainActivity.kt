package com.example.loginwithremember

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginwithremember.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mySharedPref: MySharedPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mySharedPref = MySharedPref(this)

        val isRemembered = mySharedPref.getBoolean("remember_me",false)

        if (isRemembered){
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
            return
        }

        binding.btnLogin.setOnClickListener {
            val userName = binding.etUsername.text.toString()
            val userPass = binding.etPassword.text.toString()

            if (userName == "admin" && userPass == "1234"){
                if (binding.checkRemember.isChecked){
                    mySharedPref.saveBoolean("remember_me",true)
                    mySharedPref.saveString("username",userName)
                }
                Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,HomeActivity::class.java))
                finish()
            } else{
                Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_SHORT).show()
            }
        }

    }
}