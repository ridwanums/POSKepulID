package com.example.ambarrukmo.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.R
import com.example.ambarrukmo.activity.LoginActivity
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.api.DataManager
import com.example.ambarrukmo.databinding.FragmentMemberMerchantsBinding
import com.example.ambarrukmo.viewmodel.product.ProductViewModel
import com.example.ambarrukmo.viewmodel.product.result.MerchantCategoriesItem

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MemberMerchantsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MemberMerchantsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentMemberMerchantsBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMemberMerchantsBinding.inflate(inflater, container, false)
        setEvent()
        setFragment(MemberAllMerchantFragment())
        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setEvent() {
        binding.layoutAllMerchant.setOnClickListener {
            setFragment(MemberAllMerchantFragment())
            binding.textAllMerchant.setTextColor(resources.getColor(R.color.orange))
            binding.textDining.setTextColor(resources.getColor(R.color.grey_old))
            binding.textLifestyle.setTextColor(resources.getColor(R.color.grey_old))
            binding.textStyle.setTextColor(resources.getColor(R.color.grey_old))
            binding.textBeauty.setTextColor(resources.getColor(R.color.grey_old))
            binding.textHomeLiving.setTextColor(resources.getColor(R.color.grey_old))
            binding.textKids.setTextColor(resources.getColor(R.color.grey_old))

            binding.textAllMerchant.background =  resources.getDrawable(R.drawable.ic_background_category)
            binding.textDining.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textLifestyle.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textStyle.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textBeauty.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textHomeLiving.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textKids.background =  resources.getDrawable(R.drawable.ic_background_category_un)
        }

        binding.layoutDining.setOnClickListener {
            setFragment(MemberDiningFragment())
            binding.textAllMerchant.setTextColor(resources.getColor(R.color.grey_old))
            binding.textDining.setTextColor(resources.getColor(R.color.orange))
            binding.textLifestyle.setTextColor(resources.getColor(R.color.grey_old))
            binding.textStyle.setTextColor(resources.getColor(R.color.grey_old))
            binding.textBeauty.setTextColor(resources.getColor(R.color.grey_old))
            binding.textHomeLiving.setTextColor(resources.getColor(R.color.grey_old))
            binding.textKids.setTextColor(resources.getColor(R.color.grey_old))

            binding.textAllMerchant.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textDining.background =  resources.getDrawable(R.drawable.ic_background_category)
            binding.textLifestyle.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textStyle.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textBeauty.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textHomeLiving.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textKids.background =  resources.getDrawable(R.drawable.ic_background_category_un)
        }

        binding.layoutLifestyle.setOnClickListener  {
            setFragment(MemberLifeStyleFragment())
            binding.textAllMerchant.setTextColor(resources.getColor(R.color.grey_old))
            binding.textDining.setTextColor(resources.getColor(R.color.grey_old))
            binding.textLifestyle.setTextColor(resources.getColor(R.color.orange))
            binding.textStyle.setTextColor(resources.getColor(R.color.grey_old))
            binding.textBeauty.setTextColor(resources.getColor(R.color.grey_old))
            binding.textHomeLiving.setTextColor(resources.getColor(R.color.grey_old))
            binding.textKids.setTextColor(resources.getColor(R.color.grey_old))

            binding.textAllMerchant.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textDining.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textLifestyle.background =  resources.getDrawable(R.drawable.ic_background_category)
            binding.textStyle.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textBeauty.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textHomeLiving.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textKids.background =  resources.getDrawable(R.drawable.ic_background_category_un)
        }

        binding.layoutStyle.setOnClickListener {
            setFragment(MemberStyleFragment())
            binding.textAllMerchant.setTextColor(resources.getColor(R.color.grey_old))
            binding.textDining.setTextColor(resources.getColor(R.color.grey_old))
            binding.textLifestyle.setTextColor(resources.getColor(R.color.grey_old))
            binding.textStyle.setTextColor(resources.getColor(R.color.orange))
            binding.textBeauty.setTextColor(resources.getColor(R.color.grey_old))
            binding.textHomeLiving.setTextColor(resources.getColor(R.color.grey_old))
            binding.textKids.setTextColor(resources.getColor(R.color.grey_old))

            binding.textAllMerchant.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textDining.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textLifestyle.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textStyle.background =  resources.getDrawable(R.drawable.ic_background_category)
            binding.textBeauty.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textHomeLiving.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textKids.background =  resources.getDrawable(R.drawable.ic_background_category_un)
        }

        binding.layoutBeauty.setOnClickListener {
            setFragment(MemberBeautyFragment())
            binding.textAllMerchant.setTextColor(resources.getColor(R.color.grey_old))
            binding.textDining.setTextColor(resources.getColor(R.color.grey_old))
            binding.textLifestyle.setTextColor(resources.getColor(R.color.grey_old))
            binding.textStyle.setTextColor(resources.getColor(R.color.grey_old))
            binding.textBeauty.setTextColor(resources.getColor(R.color.orange))
            binding.textHomeLiving.setTextColor(resources.getColor(R.color.grey_old))
            binding.textKids.setTextColor(resources.getColor(R.color.grey_old))

            binding.textAllMerchant.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textDining.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textLifestyle.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textStyle.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textBeauty.background =  resources.getDrawable(R.drawable.ic_background_category)
            binding.textHomeLiving.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textKids.background =  resources.getDrawable(R.drawable.ic_background_category_un)
        }

        binding.layoutHomeLiving.setOnClickListener {
            setFragment(MemberHomeLivingFragment())
            binding.textAllMerchant.setTextColor(resources.getColor(R.color.grey_old))
            binding.textDining.setTextColor(resources.getColor(R.color.grey_old))
            binding.textLifestyle.setTextColor(resources.getColor(R.color.grey_old))
            binding.textStyle.setTextColor(resources.getColor(R.color.grey_old))
            binding.textBeauty.setTextColor(resources.getColor(R.color.grey_old))
            binding.textHomeLiving.setTextColor(resources.getColor(R.color.orange))
            binding.textKids.setTextColor(resources.getColor(R.color.grey_old))

            binding.textAllMerchant.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textDining.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textLifestyle.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textStyle.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textBeauty.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textHomeLiving.background =  resources.getDrawable(R.drawable.ic_background_category)
            binding.textKids.background =  resources.getDrawable(R.drawable.ic_background_category_un)
        }

        binding.layoutKids.setOnClickListener {
            setFragment(MemberKidsFragment())
            binding.textAllMerchant.setTextColor(resources.getColor(R.color.grey_old))
            binding.textDining.setTextColor(resources.getColor(R.color.grey_old))
            binding.textLifestyle.setTextColor(resources.getColor(R.color.grey_old))
            binding.textStyle.setTextColor(resources.getColor(R.color.grey_old))
            binding.textBeauty.setTextColor(resources.getColor(R.color.grey_old))
            binding.textHomeLiving.setTextColor(resources.getColor(R.color.grey_old))
            binding.textKids.setTextColor(resources.getColor(R.color.orange))

            binding.textAllMerchant.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textDining.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textLifestyle.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textStyle.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textBeauty.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textHomeLiving.background =  resources.getDrawable(R.drawable.ic_background_category_un)
            binding.textKids.background =  resources.getDrawable(R.drawable.ic_background_category)
        }

    }

    private fun setFragment(fragment: Fragment) {
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.transition, fragment)
        fragmentTransaction.commit()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MemberMerchantsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MemberMerchantsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}