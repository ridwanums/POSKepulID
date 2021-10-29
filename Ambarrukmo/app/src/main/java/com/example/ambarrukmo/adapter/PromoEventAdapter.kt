package com.example.ambarrukmo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.codelabs.thesavia.utils.RecentUtils
import com.bumptech.glide.Glide
import com.example.ambarrukmo.databinding.ItemRecycleviewHomeBinding
import com.example.ambarrukmo.viewmodel.promo.result.PromoEventItem

class PromoEventAdapter (val data: PromoEventItem) : RecyclerView.Adapter<PromoEventAdapter.ViewHolder>(){
    inner class ViewHolder(val binding : ItemRecycleviewHomeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecycleviewHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = data[position]
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