package com.example.ambarrukmo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.adapter.FaqAdapter
import com.example.ambarrukmo.adapter.PrivacyPoliceAdapter
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.databinding.ActivityPrivacyPoliceBinding
import com.example.ambarrukmo.viewmodel.content.ContentViewModel
import com.example.ambarrukmo.viewmodel.content.result.ContentItem

class PrivacyPoliceActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPrivacyPoliceBinding

    private val contentViewModel: ContentViewModel by viewModels {
        InjectorUtils.ProvideContentfactory()
    }
    lateinit var privacyPoliceAdapter: PrivacyPoliceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrivacyPoliceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setEvent()
        setData()

    }

    private fun setEvent() {
        binding.btImageBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setData() {
        contentViewModel.getFaqData().observe(this){
            when(it){
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
                    it.data?.let { it1 -> getAdapter(it1) }
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()

                }
            }
        }
    }

    private fun getAdapter(data: ContentItem) {
        privacyPoliceAdapter = PrivacyPoliceAdapter(data, false)
        binding.recyclerViewPolice.adapter = privacyPoliceAdapter
    }
}