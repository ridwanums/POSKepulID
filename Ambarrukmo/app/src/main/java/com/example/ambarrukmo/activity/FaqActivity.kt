package com.example.ambarrukmo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.adapter.FaqAdapter
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.databinding.ActivityFaqBinding
import com.example.ambarrukmo.viewmodel.content.ContentViewModel

class FaqActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFaqBinding

    private val contentViewModel: ContentViewModel by viewModels {
        InjectorUtils.ProvideContentfactory()
    }
    private var faqAdapter = FaqAdapter(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaqBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewFaq.adapter = faqAdapter

        setEvent()
        setData()
    }


    private fun setData() {
        contentViewModel.getFaqData().observe(this){
            when(it){
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
//                    it.data?.let { it1 -> getAdapter(it1) }
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()

                }
            }
        }
    }



    private fun setEvent() {
        binding.btImageBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setRecycleView() {

    }
}