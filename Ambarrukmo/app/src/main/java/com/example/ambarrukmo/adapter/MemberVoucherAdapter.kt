package com.example.ambarrukmo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ambarrukmo.activity.DetailVoucherActivity
import com.example.ambarrukmo.databinding.ItemMemberVoucherBinding

class MemberVoucherAdapter (val data : String) : RecyclerView.Adapter<MemberVoucherAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemMemberVoucherBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMemberVoucherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contex = holder.itemView.context
        holder.binding.textItemTitle.text = data
        holder.binding.root.setOnClickListener {
            val detail = Intent(contex, DetailVoucherActivity::class.java)
            contex.startActivity(detail)
        }
    }

    override fun getItemCount(): Int {
       return 6
    }
}