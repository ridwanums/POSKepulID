package com.example.ambarrukmo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ambarrukmo.databinding.ActivityDiningBinding

class DiningActivity : AppCompatActivity() {
    private lateinit var bindig : ActivityDiningBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityDiningBinding.inflate(layoutInflater)
        setContentView(bindig.root)
    }
}