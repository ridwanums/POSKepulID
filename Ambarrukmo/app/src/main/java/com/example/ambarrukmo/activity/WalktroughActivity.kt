package com.example.ambarrukmo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.viewpager.widget.ViewPager
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.adapter.WalktroughAdapter
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.databinding.ActivityWalktroughBinding
import com.example.ambarrukmo.viewmodel.appconfig.AppConfigViewModel
import com.example.ambarrukmo.viewmodel.appconfig.walktrough.WalktroughItemList

class WalktroughActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWalktroughBinding
    var page = 0


    private val appConfigViewModel : AppConfigViewModel by viewModels {
        InjectorUtils.ProviderAppConfigWalktroughFactory()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWalktroughBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textSkip.setOnClickListener {
            val skip = Intent(this, MenuLoginActivity::class.java)
            startActivity(skip)
        }

        pagechange()
        setData()
    }

    private fun setData() {
        appConfigViewModel.getWalktroughtData().observe(this){
            when(it){
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
                    it.data?.let { it1 -> setAdapter(it1) }
                    Log.e("TAG", "setData: berhasil")
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    Log.e("TAG", "setData: gagal")
                }
            }
        }
    }

    private fun setAdapter(it1: WalktroughItemList) {
        val adapter = WalktroughAdapter(applicationContext, it1)
        binding.viewPager.adapter = adapter
    }




    private fun pagechange() {
        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixel: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                page = position
                when (position){
                    0 -> {
                        binding.imageSlide1.visibility = View.VISIBLE
                        binding.imageSlide2.visibility = View.GONE
                        binding.imageSlide3.visibility = View.GONE
                    }
                    1 -> {
                        binding.imageSlide1.visibility = View.GONE
                        binding.imageSlide2.visibility = View.VISIBLE
                        binding.imageSlide3.visibility = View.GONE
                    }
                    2 -> {
                        binding.imageSlide1.visibility = View.GONE
                        binding.imageSlide2.visibility = View.GONE
                        binding.imageSlide3.visibility = View.VISIBLE
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}