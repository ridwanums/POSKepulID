package com.example.ambarrukmo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import co.id.codelabs.thesavia.utils.InjectorUtils
import co.id.codelabs.thesavia.utils.RecentUtils
import com.bumptech.glide.util.Util
import com.example.ambarrukmo.R
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.databinding.FragmentMemberAboutBinding
import com.example.ambarrukmo.viewmodel.auth.AuthViewModel
import com.example.ambarrukmo.viewmodel.auth.result.CardUseInfoItem

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Member_About_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MemberAboutFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentMemberAboutBinding? = null
    private val binding get() = _binding!!

    private val authViewModel: AuthViewModel by viewModels {
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
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMemberAboutBinding.inflate(inflater, container, false)
        setData()
        return binding.root
    }

    private fun setData() {
        authViewModel.getCardInfoData().observe(requireActivity()){
            when(it) {
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

    private fun getData(data: CardUseInfoItem) {
        val desc = RecentUtils.fromHtml(data.about)
        binding.textDescAbout.text = desc
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Member_About_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MemberAboutFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}