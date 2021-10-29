package com.example.ambarrukmo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ambarrukmo.fragment.MemberAboutFragment
import com.example.ambarrukmo.fragment.MemberMerchantsFragment
import com.example.ambarrukmo.fragment.MemberVoucherFragment

class MemberFragmentAdapter (val data : List<String>, fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return data.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return data.get(position)
    }

    override fun getItem(position: Int): Fragment {
        var fragment : Fragment? = null
        when (position){
            0 -> fragment = MemberAboutFragment.newInstance("", "")
            1 -> fragment = MemberMerchantsFragment.newInstance("", "")
            2 -> fragment = MemberVoucherFragment.newInstance("", "")
        }
        return fragment!!
    }
}