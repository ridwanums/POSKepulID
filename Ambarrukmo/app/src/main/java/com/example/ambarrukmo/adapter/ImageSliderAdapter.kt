package com.example.ambarrukmo.adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.ambarrukmo.R
import com.example.ambarrukmo.databinding.ItemImageSliderBinding
import com.example.ambarrukmo.viewmodel.promo.result.PromoEventItem
import com.example.ambarrukmo.viewmodel.promo.result.PromoEventItemItem
import com.smarteist.autoimageslider.SliderViewAdapter

class ImageSliderAdapter(val data : PromoEventItem) : SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH>() {
    inner class SliderAdapterVH(val binding : ItemImageSliderBinding) : ViewHolder(binding.root)

    override fun getCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapterVH {
        val binding = ItemImageSliderBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return SliderAdapterVH(binding)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH?, position: Int) {
        val dataItem = data[position]
        val context = viewHolder?.itemView?.context
            Glide.with(context!!)
                .load(dataItem.promo_image)
                .fitCenter()
                .into(viewHolder.binding.imageItemSlider)
    }
}