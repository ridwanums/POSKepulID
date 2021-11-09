package com.example.ambarrukmo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ambarrukmo.adapter.TermOfUseAdapter
import com.example.ambarrukmo.databinding.ActivityTermOfUseBinding

class TermOfUseActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTermOfUseBinding

    private var termOfUseAdapter = TermOfUseAdapter(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermOfUseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewTerm.adapter = termOfUseAdapter
    }
}