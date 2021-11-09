package com.example.ambarrukmo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.adapter.ViewAllAdater
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.databinding.ActivityViewAllEventBinding
import com.example.ambarrukmo.viewmodel.product.ProductViewModel
import com.example.ambarrukmo.viewmodel.product.result.MerchantListItem

class ViewAllEventActivity : AppCompatActivity() {
    private lateinit var binding : ActivityViewAllEventBinding
    private lateinit var adapter : ViewAllAdater

    private val prductViewModel : ProductViewModel by viewModels {
        InjectorUtils.ProvideProductfactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewAllEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setEvent()
        setData()
    }

    private fun setEvent() {
        binding.imageBack.setOnClickListener { onBackPressed() }

        binding.textSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter.filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }

    private fun setData() {
        prductViewModel.getMerchantData().observe(this){
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

    private fun getAdapter(data: MerchantListItem) {
        adapter = ViewAllAdater(data)
        binding.recyclerViewViewAll.adapter = adapter
    }
}