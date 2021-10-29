package com.example.ambarrukmo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ambarrukmo.databinding.ActivityLoginBinding
import com.example.ambarrukmo.databinding.ActivityLoginMenuBinding

class MenuLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val toLogin = Intent(this, LoginActivity::class.java)
            startActivity(toLogin)
        }

        binding.btnRegister.setOnClickListener {
            val toRegister = Intent(this, RegisterActivity::class.java)
            startActivity(toRegister)
//            val dialog = DialogRegisterFragment()
//            dialog.show(supportFragmentManager, dialog.tag)
//            binding.btnRegister.visibility = View.GONE
//            binding.btnLogin.visibility = View.GONE
        }
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        val back = Intent(applicationContext, WalktroughActivity::class.java)
//        startActivity(back)
//    }
}