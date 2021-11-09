package com.example.ambarrukmo.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.viewpager.widget.ViewPager
import co.id.codelabs.thesavia.utils.InjectorUtils
import co.id.codelabs.thesavia.utils.RecentUtils
import com.example.ambarrukmo.adapter.MerchantsDetailViewAdapter
import com.example.ambarrukmo.adapter.TestimonialAdapter
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.api.AppConstants
import com.example.ambarrukmo.databinding.ActivityDetailMerchantsBinding
import com.example.ambarrukmo.viewmodel.product.ProductViewModel
import com.example.ambarrukmo.viewmodel.product.result.DetailMerchantsItem

class DetailMerchantsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailMerchantsBinding
    private lateinit var detailMerchantsItem: DetailMerchantsItem

    private val productViewModel : ProductViewModel by viewModels {
        InjectorUtils.ProvideProductfactory()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMerchantsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setEvent()
        PageChangeImage()
        setData()
    }

    private fun setEvent() {
        binding.buttonCall.setOnClickListener {
            val dial = "tel:"+detailMerchantsItem.merchant_phone
            val call = Intent(Intent.ACTION_DIAL, Uri.parse(dial))
            startActivity(call)
        }
    }

    private fun PageChangeImage() {
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

        binding.viewPagerTestimony.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
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
        detailMerchantsItem = data
        val adapter = MerchantsDetailViewAdapter(applicationContext, data)
        val testimonial = TestimonialAdapter(applicationContext, data)

        binding.viewPagerCategory.adapter = adapter
        binding.viewPagerTestimony.adapter = testimonial

        val desc = RecentUtils.fromHtml(data.merchant_description)
        binding.textRatting.setRating(data.total_rating_stars.toFloat())
        binding.textNameMerchants.text = data.merchant_name
        binding.textAddress.text = data.merchant_address
        binding.textNilai.text = data.total_rating
        binding.textCategory.text = data.categories.first().cat_name
        binding.textDesc.text = desc
    }

    fun prev(view: View) {
        binding.viewPagerTestimony.setCurrentItem(binding.viewPagerTestimony.getCurrentItem()-1, true)
    }

    fun next(view: View) {
        binding.viewPagerTestimony.setCurrentItem(binding.viewPagerTestimony.getCurrentItem()+1, true)
    }


}