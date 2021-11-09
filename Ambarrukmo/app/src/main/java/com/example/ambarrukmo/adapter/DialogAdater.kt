package com.example.ambarrukmo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ambarrukmo.api.DataManager
import com.example.ambarrukmo.databinding.ItemDialogBinding
import com.example.ambarrukmo.viewmodel.product.result.LevelFloorItem
import com.example.ambarrukmo.viewmodel.promo.result.Merchant

class DialogAdater(val data : LevelFloorItem) : RecyclerView.Adapter<DialogAdater.ViewHolder> () {
    val merchant = data.first().merchants
    inner class ViewHolder (val binding : ItemDialogBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDialogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = merchant[position]
        holder.binding.textName.text = dataItem.merchant_name
        Glide.with(holder.itemView.context).load(dataItem.merchant_logo).into(holder.binding.imgLogo)
    }

    override fun getItemCount(): Int {
        return merchant.size
    }
}