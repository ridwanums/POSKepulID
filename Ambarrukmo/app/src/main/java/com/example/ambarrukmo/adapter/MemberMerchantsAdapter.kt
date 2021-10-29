package com.example.ambarrukmo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ambarrukmo.fragment.Merchan_Merchan_Fragment

class MemberMerchantsAdapter    (val data: List<String>, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return data.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return data.get(position)
    }


    override fun getItem(position: Int): Fragment {
        return Merchan_Merchan_Fragment.newInstance("","")
    }
}