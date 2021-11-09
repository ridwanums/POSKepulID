package com.example.ambarrukmo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ambarrukmo.adapter.PrivacyPoliceAdapter
import com.example.ambarrukmo.databinding.ActivityPrivacyPoliceBinding

class PrivacyPoliceActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPrivacyPoliceBinding

    private var privacyPoliceAdapter = PrivacyPoliceAdapter(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrivacyPoliceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewPolice.adapter = privacyPoliceAdapter
    }
}