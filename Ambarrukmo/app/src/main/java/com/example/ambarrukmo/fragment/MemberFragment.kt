package com.example.ambarrukmo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.R
import com.example.ambarrukmo.adapter.MemberFragmentAdapter
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.databinding.FragmentMemberBinding
import com.example.ambarrukmo.viewmodel.auth.AuthViewModel
import com.example.ambarrukmo.viewmodel.auth.result.AuthenticateUserItem

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MemberFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MemberFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentMemberBinding? = null
    private val binding get() = _binding!!

    private val authViewModel : AuthViewModel by viewModels {
        InjectorUtils.ProviderAuthFactory()
    }

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
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMemberBinding.inflate(layoutInflater, container, false)
        setTab()
        setData()
        return binding.root
    }

    private fun setTab() {
        val title : MutableList<String> = ArrayList()
        title.add("About")
        title.add("Merchants")
        title.add("My Voucher")
        binding.viewPager.adapter = (MemberFragmentAdapter(title, childFragmentManager))
        binding.tabLayout.setupWithViewPager(binding.viewPager)

    }

    private fun setData() {
        authViewModel.getAuthenticeUserData().observe(requireActivity()){
            when(it){
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
                    it.data?.let { it1 -> getData(it1) }
                }
                is ApiCallback.OnError -> {

                }
            }
        }
    }

    private fun getData(data: AuthenticateUserItem) {
        binding.textName.text = data.mbr_nama
        binding.textType.text = data.type
        binding.textNumberPoint.text = data.mbr_point.toString() +" Point"
        binding.textCode.text = data.mbr_kode
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MemberFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MemberFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}