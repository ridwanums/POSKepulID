package com.example.ambarrukmo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.ambarrukmo.R
import com.example.ambarrukmo.viewmodel.product.result.DetailMerchantsItem

class MerchantsDetailViewAdapter (var context: Context, private val data : DetailMerchantsItem) : PagerAdapter() {
    private var layoutInflater: LayoutInflater? = null
    val image = data.images
    override fun getCount(): Int {
        return image.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val dataItem = image[position]
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.item_detail_merchant_view_image, null)
        val imageView = view.findViewById<ImageView>(R.id.image_view)
        Glide.with(context).load(dataItem.mc_image_filename).into(imageView)
        val viewPager = container as ViewPager
        viewPager.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }
}