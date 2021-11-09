package com.example.ambarrukmo.activity

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.adapter.ViewAllAdater
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.databinding.ActivityViewAllWhatNameBinding
import com.example.ambarrukmo.viewmodel.product.ProductViewModel
import com.example.ambarrukmo.viewmodel.product.result.MerchantListItem

class ViewAllWhatNameActivity : AppCompatActivity() {
    private lateinit var binding : ActivityViewAllWhatNameBinding
    private lateinit var adapter : ViewAllAdater

    private val prductViewModel : ProductViewModel by viewModels {
        InjectorUtils.ProvideProductfactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewAllWhatNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.BLACK
        }

        setEvent()
        setData()
    }

    private fun setEvent() {
        binding.imageBack.setOnClickListener { onBackPressed() }

       binding.textSearch.addTextChangedListener(object : TextWatcher{
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