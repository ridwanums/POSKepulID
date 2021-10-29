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
        val context = viewHolder!!.itemView.context
        if(dataItem.promo_image.isNotEmpty()){
            Glide.with(context)
                .load(dataItem.promo_image)
                .into(viewHolder.binding.imageItemSlider)
        } else {
            Glide.with(context)
                .load(R.drawable.no_image)
                .into(viewHolder.binding.imageItemSlider)
        }
    }
}
//    override fun getCount(): Int {
//        return data.size
//    }
//
//
//    override fun onCreateViewHolder(parent: ViewGroup?): ImageSliderAdapter.SliderAdapterVH {
//        val layoutInflater = LayoutInflater.from(parent?.context).inflate(R.layout.item_image_slider, null)
//        return SliderAdapterVH(layoutInflater)
//    }
//
//    override fun onBindViewHolder(viewHolder: ImageSliderAdapter.SliderAdapterVH?, position: Int) {
//        val dataItem : PromoEventItemItem = data[position]
//        val context = viewHolder?.itemView?.context
//
//        if (data.isEmpty()){
//            Glide.with(context!!)
//                .load(R.drawable.no_image)
//                .into(viewHolder.banner)
//        } else {
//            Glide.with(context!!)
//                .load(dataItem.promo_image)
//                .into(viewHolder.banner)
//        }
//    }
//
//    inner class SliderAdapterVH(itemView: View?) : ViewHolder(itemView) {
//        var banner: ImageView = itemView!!.findViewById(R.id.image_item_slide)
//
//    }
//
//}