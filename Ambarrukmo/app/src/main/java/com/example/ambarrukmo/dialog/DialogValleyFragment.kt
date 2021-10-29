package com.example.ambarrukmo.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import co.id.codelabs.thesavia.utils.RecentUtils
import com.example.ambarrukmo.databinding.FragmentDialogValleyBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DialogValleyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DialogValleyFragment(val statuscode: Int?, val message : String?) : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentDialogValleyBinding? = null
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
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDialogValleyBinding.inflate(inflater, container, false)
        setEvent()

        return binding.root
    }

    private fun setEvent() {
        binding.textNumber.text = RecentUtils.fromHtml(message)
        if (statuscode == 200){
            binding.textMessage.text = "Successfully booking parking Valley"
        } else {
            binding.textMessage.text = "UnSuccessfully booking parking Valley"
        }

         binding.btnOk.setOnClickListener {
             this.dismiss()
         }
    }
}