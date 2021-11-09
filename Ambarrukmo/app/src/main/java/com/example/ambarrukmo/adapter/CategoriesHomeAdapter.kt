package com.example.ambarrukmo.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ambarrukmo.activity.ViewAllEventActivity
import com.example.ambarrukmo.activity.ViewAllWhatNameActivity
import com.example.ambarrukmo.databinding.ItemItemPromocategoriesHomeBinding
import com.example.ambarrukmo.databinding.ItemPromocategoriesHomeBinding
import com.example.ambarrukmo.viewmodel.promo.result.Promotion
import com.example.ambarrukmo.viewmodel.promo.result.PromotionCategoryItem
import com.example.ambarrukmo.viewmodel.promo.result.PromotionCategoryItemItem

class CategoriesHomeAdapter (val data : PromotionCategoryItem) : RecyclerView.Adapter<CategoriesHomeAdapter.ViewHolder> () {
    inner class ViewHolder (val binding : ItemPromocategoriesHomeBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPromocategoriesHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("WrongConstant")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem : PromotionCategoryItemItem = data[position]
        val context = holder.itemView.context
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.binding.textCategory.text = dataItem.cat_promo_title
        holder.binding.textViewAll.text = "View all"
        holder.binding.recycleItemHome.adapter = PromotionAdapter(dataItem.promotions)
        holder.binding.recycleItemHome.layoutManager = linearLayoutManager


        holder.itemView.setOnClickListener {
            when (dataItem.cat_promo_id){
                5 -> {
                    val new = Intent(context, ViewAllWhatNameActivity::class.java)
                    context.startActivity(new)
                }

                6 -> {
                    val new = Intent(context, ViewAllEventActivity::class.java)
                    context.startActivity(new)
//                    Toast.makeText(context, "On Develop", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class PromotionAdapter (val data : List<Promotion>) : RecyclerView.Adapter<PromotionAdapter.ViewHolder> (){
    inner class ViewHolder (val binding: ItemItemPromocategoriesHomeBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemItemPromocategoriesHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = data[position]
        holder.binding.textTitle.text = dataItem.promo_title
        holder.binding.textSubtitle.text = dataItem.merchant_promo.merchant_name
        Glide.with(holder.itemView.context).load(dataItem.promo_image).into(holder.binding.imgItemCategories)
    }

    override fun getItemCount(): Int {
        return  data.size
    }
}