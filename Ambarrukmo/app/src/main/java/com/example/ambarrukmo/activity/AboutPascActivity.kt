package com.example.ambarrukmo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ambarrukmo.databinding.ActivityAboutPascBinding

class AboutPascActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAboutPascBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutPascBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}