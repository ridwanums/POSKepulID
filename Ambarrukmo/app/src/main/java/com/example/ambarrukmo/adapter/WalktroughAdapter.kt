package com.example.ambarrukmo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.ambarrukmo.R
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.databinding.ActivityWalktroughBinding
import com.example.ambarrukmo.databinding.ItemWalkthroughBinding
import com.example.ambarrukmo.viewmodel.appconfig.walktrough.WalktroughItem
import com.example.ambarrukmo.viewmodel.appconfig.walktrough.WalktroughItemList

class WalktroughAdapter(var context: Context, private val data: WalktroughItemList) : PagerAdapter() {
    private var layoutInflater: LayoutInflater? = null
    override fun getCount(): Int {
        return data.size
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view === o
    }


    @SuppressLint("ResourceType")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val dataItem = data[position]
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.item_walkthrough, null)
        val title = view.findViewById<TextView>(R.id.text_item_title)
        val desc = view.findViewById<TextView>(R.id.text_item_desc)
        val imageView = view.findViewById<ImageView>(R.id.image_item_slide)
        title.text = dataItem.walkthrough_title
        desc.text = dataItem.walkthrough_content
        Glide.with(context).load(dataItem.walkthrough_image).into(imageView)
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