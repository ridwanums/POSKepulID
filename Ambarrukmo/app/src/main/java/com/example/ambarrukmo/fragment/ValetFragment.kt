package com.example.ambarrukmo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ambarrukmo.R
import com.example.ambarrukmo.databinding.FragmentValetBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ValetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ValetFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentValetBinding? = null
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
        _binding = FragmentValetBinding.inflate(inflater, container, false)
        setTab()
        setFragment(ValetNewFragment())
        return binding.root
    }

    private fun setTab() {
        binding.view1.visibility = View.VISIBLE
        binding.view2.visibility = View.GONE

        binding.layoutAdd.setOnClickListener {
            setFragment(ValetNewFragment())
            binding.textAdd.setTextColor(resources.getColor(R.color.brown))
            binding.textHistory.setTextColor(resources.getColor(R.color.grey_old))
            binding.view2.visibility = View.GONE
            binding.view1.visibility = View.VISIBLE
        }

        binding.layoutHistory.setOnClickListener {
            setFragment(ValetHistoryFragment())
            binding.textAdd.setTextColor(resources.getColor(R.color.grey_old))
            binding.textHistory.setTextColor(resources.getColor(R.color.brown))
            binding.view1.visibility = View.GONE
            binding.view2.visibility = View.VISIBLE
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
         * @return A new instance of fragment ValetFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ValetFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}