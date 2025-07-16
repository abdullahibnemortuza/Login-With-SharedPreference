package com.example.loginwithremember

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginwithremember.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var mySharedPref: MySharedPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mySharedPref = MySharedPref(this)

        val userName = mySharedPref.getString("username","user")
        binding.userTV.text = "Username: $userName"

        binding.btnLogOut.setOnClickListener {
            mySharedPref.removeKey("remember_me")
            mySharedPref.removeKey("username")
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}