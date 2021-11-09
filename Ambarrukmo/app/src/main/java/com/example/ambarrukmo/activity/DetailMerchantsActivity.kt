package com.example.ambarrukmo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.viewpager.widget.ViewPager
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.adapter.MerchantsDetailViewAdapter
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.databinding.ActivityDetailMerchantsBinding
import com.example.ambarrukmo.viewmodel.product.ProductViewModel
import com.example.ambarrukmo.viewmodel.product.result.DetailMerchantsItem

class DetailMerchantsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailMerchantsBinding

    private val productViewModel : ProductViewModel by viewModels {
        InjectorUtils.ProvideProductfactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMerchantsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        PageChange()
        setData()
    }

    private fun PageChange() {
        binding.viewPagerCategory.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixel: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun setData() {
        productViewModel.getDetailMerchantsData().observe(this){
            when(it){
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

    private fun getData(data: DetailMerchantsItem) {
        val adapter = MerchantsDetailViewAdapter(applicationContext, data)
        binding.viewPagerCategory.adapter = adapter
    }


}