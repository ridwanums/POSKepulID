package com.example.ambarrukmo.dialog

import android.icu.text.Transliterator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.adapter.DialogAdater
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.api.DataManager
import com.example.ambarrukmo.databinding.FragmentDilaogMapBinding
import com.example.ambarrukmo.viewmodel.product.ProductViewModel
import com.example.ambarrukmo.viewmodel.product.result.LevelFloorItem
import okhttp3.MultipartBody

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DilaogMapFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DilaogMapFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _bindning : FragmentDilaogMapBinding? = null
    private val binding get() = _bindning!!

    private val productViewModel : ProductViewModel by viewModels {
        InjectorUtils.ProvideProductfactory()
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
        _bindning = FragmentDilaogMapBinding.inflate(inflater, container, false)
        setDial()
        setEvent()
        return binding.root
    }

    private fun setEvent() {
        binding.imageClose.setOnClickListener {
            dismiss()
        }
    }

    private fun setDial() {
        val formBuilder = MultipartBody.Builder()
        formBuilder.setType(MultipartBody.FORM)
        formBuilder.addFormDataPart("floor_code", DataManager.getInstance().floormap.toString())
        val formBody = formBuilder.build()
        productViewModel.getLevelFloorData(formBody).observe(requireActivity()){
            when(it){
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
                    it.data?.let { it1 -> setAdapter(it1) }
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun setAdapter(data: LevelFloorItem) {
        binding.recyclerViewDialog.adapter = DialogAdater(data)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DilaogMapFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DilaogMapFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}