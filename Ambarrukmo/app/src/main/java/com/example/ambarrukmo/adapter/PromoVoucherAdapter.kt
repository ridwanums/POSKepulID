package com.example.ambarrukmo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.codelabs.thesavia.utils.RecentUtils
import com.bumptech.glide.Glide
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.databinding.*
import com.example.ambarrukmo.viewmodel.promo.result.PromoEventItem
import com.example.ambarrukmo.viewmodel.promo.result.PromotionCategoryItem
import com.example.ambarrukmo.viewmodel.promo.result.PromotionListItem
import com.example.ambarrukmo.viewmodel.promo.result.PromotionListItemItem

class PromoVoucherAdapter (val data : String) : RecyclerView.Adapter<PromoVoucherAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemHomeVoucherBinding): RecyclerView.ViewHolder(binding.root){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeVoucherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textItemPromo.text = data
    }

    override fun getItemCount(): Int {
        return 3
    }
}