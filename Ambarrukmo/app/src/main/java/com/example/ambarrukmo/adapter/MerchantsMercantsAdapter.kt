package com.example.ambarrukmo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ambarrukmo.activity.DetailVoucherActivity
import com.example.ambarrukmo.databinding.ItemMemberVoucherBinding
import com.example.ambarrukmo.databinding.ItemMerchanFragmentBinding

class MerchantsMercantsAdapter (val data : String) : RecyclerView.Adapter<MerchantsMercantsAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemMerchanFragmentBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMerchanFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contex = holder.itemView.context
        holder.binding.textNameMerchants.text = data
    }

    override fun getItemCount(): Int {
        return 2
    }
}