package com.example.ambarrukmo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.adapter.FaqAdapter
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.databinding.ActivityFaqBinding
import com.example.ambarrukmo.viewmodel.content.ContentViewModel
import com.example.ambarrukmo.viewmodel.content.result.ContentItem
import com.example.ambarrukmo.viewmodel.content.result.Faq

class FaqActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFaqBinding

    private val contentViewModel: ContentViewModel by viewModels {
        InjectorUtils.ProvideContentfactory()
    }
    lateinit var faqAdapter : FaqAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaqBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setEvent()
        setData()
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
        faqAdapter = FaqAdapter(data, false)
        binding.recyclerViewFaq.adapter = faqAdapter
    }


    private fun setEvent() {
        binding.btImageBack.setOnClickListener {
            onBackPressed()
        }
    }
}