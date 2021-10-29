package com.example.ambarrukmo.activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.R
import com.example.ambarrukmo.databinding.ActivityMainBinding
import com.example.ambarrukmo.fragment.*
import com.example.ambarrukmo.viewmodel.valet.ValetViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding



    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgHomes.setImageDrawable(resources.getDrawable(R.drawable.homeicorange))
        binding.textHome.setTextColor(resources.getColor(R.color.orange))
        setFragment(HomeFragment())
        setEvent()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setEvent() {
        binding.layoutHome.setOnClickListener {
            setFragment(HomeFragment())
            binding.imgHomes.setImageDrawable(resources.getDrawable(R.drawable.homeicorange))
            binding.imgValet.setImageDrawable(resources.getDrawable(R.drawable.valeticwhite))
            binding.imgMaps.setImageDrawable(resources.getDrawable(R.drawable.mapicwhite))
            binding.imgMember.setImageDrawable(resources.getDrawable(R.drawable.membericwhite))
            binding.imgSetting.setImageDrawable(resources.getDrawable(R.drawable.settingicwhite))

            binding.textHome.setTextColor(resources.getColor(R.color.orange))
            binding.textValet.setTextColor(resources.getColor(R.color.white))
            binding.textMaps.setTextColor(resources.getColor(R.color.white))
            binding.textmember.setTextColor(resources.getColor(R.color.white))
            binding.textSetting.setTextColor(resources.getColor(R.color.white))

            binding.layoutLogo.visibility = View.VISIBLE
        }

        binding.layoutValet.setOnClickListener {
            setFragment(ValetFragment())
            binding.imgHomes.setImageDrawable(resources.getDrawable(R.drawable.homeicwhite))
            binding.imgValet.setImageDrawable(resources.getDrawable(R.drawable.valeticorange))
            binding.imgMaps.setImageDrawable(resources.getDrawable(R.drawable.mapicwhite))
            binding.imgMember.setImageDrawable(resources.getDrawable(R.drawable.membericwhite))
            binding.imgSetting.setImageDrawable(resources.getDrawable(R.drawable.settingicwhite))

            binding.textHome.setTextColor(resources.getColor(R.color.white))
            binding.textValet.setTextColor(resources.getColor(R.color.orange))
            binding.textMaps.setTextColor(resources.getColor(R.color.white))
            binding.textmember.setTextColor(resources.getColor(R.color.white))
            binding.textSetting.setTextColor(resources.getColor(R.color.white))

            binding.layoutLogo.visibility = View.VISIBLE

        }

        binding.layoutMap.setOnClickListener {
            setFragment(MapFragment())
            binding.imgHomes.setImageDrawable(resources.getDrawable(R.drawable.homeicwhite))
            binding.imgValet.setImageDrawable(resources.getDrawable(R.drawable.valeticwhite))
            binding.imgMaps.setImageDrawable(resources.getDrawable(R.drawable.mapicorange))
            binding.imgMember.setImageDrawable(resources.getDrawable(R.drawable.membericwhite))
            binding.imgSetting.setImageDrawable(resources.getDrawable(R.drawable.settingicwhite))

            binding.textHome.setTextColor(resources.getColor(R.color.white))
            binding.textValet.setTextColor(resources.getColor(R.color.white))
            binding.textMaps.setTextColor(resources.getColor(R.color.orange))
            binding.textmember.setTextColor(resources.getColor(R.color.white))
            binding.textSetting.setTextColor(resources.getColor(R.color.white))

            binding.layoutLogo.visibility = View.VISIBLE
        }

        binding.layoutMember.setOnClickListener {
            setFragment(MemberFragment())
            binding.imgHomes.setImageDrawable(resources.getDrawable(R.drawable.homeicwhite))
            binding.imgValet.setImageDrawable(resources.getDrawable(R.drawable.valeticwhite))
            binding.imgMaps.setImageDrawable(resources.getDrawable(R.drawable.mapicwhite))
            binding.imgMember.setImageDrawable(resources.getDrawable(R.drawable.membericorange))
            binding.imgSetting.setImageDrawable(resources.getDrawable(R.drawable.settingicwhite))

            binding.textHome.setTextColor(resources.getColor(R.color.white))
            binding.textValet.setTextColor(resources.getColor(R.color.white))
            binding.textMaps.setTextColor(resources.getColor(R.color.white))
            binding.textmember.setTextColor(resources.getColor(R.color.orange))
            binding.textSetting.setTextColor(resources.getColor(R.color.white))

            binding.layoutLogo.visibility = View.GONE
        }

        binding.layoutSetting.setOnClickListener {
            setFragment(SettingFragment())
            binding.imgHomes.setImageDrawable(resources.getDrawable(R.drawable.homeicwhite))
            binding.imgValet.setImageDrawable(resources.getDrawable(R.drawable.valeticwhite))
            binding.imgMaps.setImageDrawable(resources.getDrawable(R.drawable.mapicwhite))
            binding.imgMember.setImageDrawable(resources.getDrawable(R.drawable.membericwhite))
            binding.imgSetting.setImageDrawable(resources.getDrawable(R.drawable.settingicorange))

            binding.textHome.setTextColor(resources.getColor(R.color.white))
            binding.textValet.setTextColor(resources.getColor(R.color.white))
            binding.textMaps.setTextColor(resources.getColor(R.color.white))
            binding.textmember.setTextColor(resources.getColor(R.color.white))
            binding.textSetting.setTextColor(resources.getColor(R.color.orange))

            binding.layoutLogo.visibility = View.VISIBLE
        }
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.transition, fragment)
        fragmentTransaction.commit()
    }
}


//        val homeFragment = HomeFragment()
//        val valetFragment = ValetFragment()
//        val mapFragment = MapFragment()
//        val memberFragment = MemberFragment()
//        val settingFragment = SettingFragment()
//
//        makeCurrentFragment(homeFragment)
//
//
//        binding.navbarMain.setOnNavigationItemSelectedListener {
//            when(it.itemId){
//                R.id.home -> {
//                    makeCurrentFragment(homeFragment)
//                    binding.layoutLogo.visibility = View.VISIBLE
//                }
//                R.id.valet -> {
//                    makeCurrentFragment(valetFragment)
//                    binding.layoutLogo.visibility = View.VISIBLE
//                }
//                R.id.member -> {
//                    makeCurrentFragment(memberFragment)
//                    binding.layoutLogo.visibility = View.GONE
//                }
//                R.id.map -> {
//                    makeCurrentFragment(mapFragment)
//                    binding.layoutLogo.visibility = View.VISIBLE
//                }
//                R.id.setting -> {
//                    makeCurrentFragment(settingFragment)
//                    binding.layoutLogo.visibility = View.VISIBLE
//                }
//            }
//            true
//        }
//    }
//
//    private fun makeCurrentFragment(fragment : Fragment) = supportFragmentManager.beginTransaction().apply {
//        replace(R.id.transition, fragment)
//        commit()
//    }
//}