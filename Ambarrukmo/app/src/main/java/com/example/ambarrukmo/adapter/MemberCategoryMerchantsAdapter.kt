package com.example.ambarrukmo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ambarrukmo.activity.DetailMerchantsActivity
import com.example.ambarrukmo.databinding.ItemViewallBinding
import com.example.ambarrukmo.viewmodel.product.result.MerchantCategory

class MemberCategoryMerchantsAdapter (val data : MerchantCategory) : RecyclerView.Adapter<MemberCategoryMerchantsAdapter.ViewHolder>() {
    val merchants = data.merchants
    inner class ViewHolder (val binding : ItemViewallBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = merchants[position]
        val context = holder.itemView.context
        holder.binding.textTitle.text = dataItem.merchant_name
        holder.binding.textSubtitle.text = dataItem.merchant_location_floor_txt
        Glide.with(context).load(dataItem.merchant_logo).into(holder.binding.imageLogo)

        holder.binding.root.setOnClickListener {
            val view = Intent(context, DetailMerchantsActivity::class.java)
            context.startActivity(view)
        }

    }

    override fun getItemCount(): Int {
        return merchants.size
    }

}
