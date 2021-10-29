package com.example.ambarrukmo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.adapter.MerchantAdapter
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.databinding.ActivityViewAllPromotionListBinding
import com.example.ambarrukmo.viewmodel.product.ProductViewModel
import com.example.ambarrukmo.viewmodel.product.result.MerchantListItem
import com.example.ambarrukmo.viewmodel.promo.PromoViewModel
import com.example.ambarrukmo.viewmodel.promo.result.PromotionListItem

class ViewAllPromotionListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityViewAllPromotionListBinding
    private val promoViewModel : PromoViewModel by viewModels {
        InjectorUtils.ProvidePromoFactory()
    }

    private val productViewModel: ProductViewModel by viewModels {
        InjectorUtils.ProvideProductfactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewAllPromotionListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()

    }

    private fun getData() {
        productViewModel.getMerchantData().observe(this){
            when(it){
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
                    it.data?.let { it1 -> setData(it1) }
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun setData(data: MerchantListItem) {
        binding.recycleView.adapter = MerchantAdapter(data)
    }
}