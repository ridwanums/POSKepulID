package com.example.ambarrukmo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ambarrukmo.databinding.ActivityMyProfileBinding

class MyProfileActivity : AppCompatActivity() {
    lateinit var binding : ActivityMyProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setEvent()
    }

    private fun setEvent() {
        binding.btnEdit.setOnClickListener {
            val edit = Intent(this, EditProfileActivity::class.java)
            startActivity(edit)
        }
    }
}