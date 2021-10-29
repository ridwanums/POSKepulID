package com.example.ambarrukmo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ambarrukmo.databinding.ActivityDetailVoucherBinding

class DetailVoucherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailVoucherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailVoucherBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}