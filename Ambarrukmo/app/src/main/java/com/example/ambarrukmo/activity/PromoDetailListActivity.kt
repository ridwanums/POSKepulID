package com.example.ambarrukmo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ambarrukmo.databinding.ActivityPromoDetailListBinding

class PromoDetailListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPromoDetailListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPromoDetailListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}