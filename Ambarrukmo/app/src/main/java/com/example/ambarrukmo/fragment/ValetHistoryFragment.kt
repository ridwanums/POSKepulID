package com.example.ambarrukmo.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.R
import com.example.ambarrukmo.activity.LoginActivity
import com.example.ambarrukmo.adapter.ValetFragmentHistoryAdapter
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.databinding.FragmentValetHistoryBinding
import com.example.ambarrukmo.viewmodel.valet.ValetViewModel
import com.example.ambarrukmo.viewmodel.valet.result.ValetHistoryItem

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ValetHistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ValetHistoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentValetHistoryBinding? = null
    private val binding get() = _binding!!

    private val valetViewModel : ValetViewModel by viewModels {
        InjectorUtils.ProvideValetfactory()
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
        _binding = FragmentValetHistoryBinding.inflate(inflater, container, false)
        setData()
        return binding.root
    }

    private fun setData() {
        valetViewModel.getValetHistoryData().observe(requireActivity()){
            when(it){
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
                    it.data?.let { it1 -> setHistoryValet(it1) }
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    val out = Intent(requireContext(), LoginActivity::class.java)
                    out.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(out)

                }
            }
        }
    }

    private fun setHistoryValet(it1: ValetHistoryItem) {
        binding.recycleValetHistory.adapter = ValetFragmentHistoryAdapter(it1)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ValetHistoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ValetHistoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}