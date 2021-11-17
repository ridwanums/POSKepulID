package com.example.ambarrukmo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ambarrukmo.activity.DetailMerchantsActivity
import com.example.ambarrukmo.api.DataManager
import com.example.ambarrukmo.databinding.ItemCategoryBinding
import com.example.ambarrukmo.viewmodel.product.result.MerchantCategory

class CategoryAdapter (val data : MerchantCategory) : RecyclerView.Adapter<CategoryAdapter.ViewHolder> (), Filterable{
    val merchants = data.merchants
    inner class ViewHolder (val binding : ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = merchants[position]
        val context = holder.itemView.context
        Glide.with(context).load(dataItem.merchant_logo).into(holder.binding.imgDiningProduct)
        holder.binding.textTitle.text = dataItem.pasc_discount_txt
        holder.binding.textTime.text = dataItem.updated_at

        holder.binding.btnView.setOnClickListener {
            val detail = Intent(context, DetailMerchantsActivity::class.java)
            context.startActivity(detail)
            DataManager.getInstance().merchant_id = dataItem.merchant_id.toString()
            Toast.makeText(context, DataManager.getInstance().merchant_id, Toast.LENGTH_LONG).show()

        }
    }

    override fun getItemCount(): Int {
        return merchants.size

    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }
}