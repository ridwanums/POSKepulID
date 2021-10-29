package com.example.ambarrukmo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.codelabs.thesavia.utils.RecentUtils
import com.bumptech.glide.Glide
import com.example.ambarrukmo.databinding.ItemMerchanViewallBinding
import com.example.ambarrukmo.databinding.ItemRecycleviewHomeBinding
import com.example.ambarrukmo.viewmodel.product.result.MerchantListItem
import com.example.ambarrukmo.viewmodel.promo.result.Merchant
import com.example.ambarrukmo.viewmodel.promo.result.PromotionListItem
import com.example.ambarrukmo.viewmodel.promo.result.PromotionListItemItem

class PromoListAdapter (val data: PromotionListItem) : RecyclerView.Adapter<PromoListAdapter.ViewHolder>(){
    inner class ViewHolder(val binding : ItemRecycleviewHomeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecycleviewHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem : PromotionListItemItem = data[position]
        val desc = RecentUtils.fromHtml(dataItem.promo_description)
        holder.binding.textDiscount.text = dataItem.promo_title
        holder.binding.textPlace.text = desc
        Glide.with(holder.itemView.context)
            .load(dataItem.promo_image)
            .into(holder.binding.imageItemBanner)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class MerchantAdapter (val data : MerchantListItem) : RecyclerView.Adapter<MerchantAdapter.ViewHolder>(){
    inner class ViewHolder(val binding : ItemMerchanViewallBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMerchanViewallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = data[position]
        holder.binding.textNameMerchants.text = dataItem.merchant_name
        holder.binding.textPlace.text = dataItem.merchant_location_floor_txt
        Glide.with(holder.itemView.context).load(dataItem.merchant_logo).into(holder.binding.imageMerchant)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}


