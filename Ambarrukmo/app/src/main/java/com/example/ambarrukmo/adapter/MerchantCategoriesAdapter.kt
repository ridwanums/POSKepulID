package com.example.ambarrukmo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ambarrukmo.SplashScreenActivity
import com.example.ambarrukmo.activity.LoginActivity
import com.example.ambarrukmo.activity.WalktroughActivity
import com.example.ambarrukmo.databinding.ItemMemberVoucherBinding
import com.example.ambarrukmo.databinding.ItemMerchantCategoriesBinding
import com.example.ambarrukmo.viewmodel.product.result.MerchantCategoriesItem

class MerchantCategoriesAdapter (val data : MerchantCategoriesItem) : RecyclerView.Adapter<MerchantCategoriesAdapter.ViewHolder> () {
    inner class ViewHolder(val binding: ItemMerchantCategoriesBinding): RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMerchantCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = data[position]
        val context = holder.itemView.context
        Glide.with(context).load(dataItem.cat_image).into(holder.binding.imgCategories)
        holder.binding.textCategories.text = dataItem.cat_name

        holder.binding.root.setOnClickListener {
            when(dataItem.cat_id){
                1 -> Toast.makeText(context, "On Develop", Toast.LENGTH_LONG).show()
                2 -> Toast.makeText(context, "On Develop", Toast.LENGTH_LONG).show()
                3 -> Toast.makeText(context, "On Develop", Toast.LENGTH_LONG).show()
                4 -> Toast.makeText(context, "On Develop", Toast.LENGTH_LONG).show()
                5 -> Toast.makeText(context, "On Develop", Toast.LENGTH_LONG).show()
                6 -> Toast.makeText(context, "On Develop", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}