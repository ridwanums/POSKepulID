package com.example.ambarrukmo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.adapter.CategoryAdapter
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.databinding.ActivityDiningBinding
import com.example.ambarrukmo.viewmodel.product.ProductViewModel
import com.example.ambarrukmo.viewmodel.product.result.MerchantCategory

class DiningActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDiningBinding

    private val productViewModel : ProductViewModel by viewModels {
        InjectorUtils.ProvideProductfactory()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        setEvent()
    }

    private fun setEvent() {
        binding.imgBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setData() {
        productViewModel.getCategoryDiningData().observe(this){
            when (it ){
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
                    it.data?.let { it1 -> getData(it1) }
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun getData(data: MerchantCategory) {
        binding.recyclerViewDining.adapter = CategoryAdapter(data)
        binding.textTitle.text = data.cat_name
    }
}