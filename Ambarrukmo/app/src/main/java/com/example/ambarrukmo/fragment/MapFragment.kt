package com.example.ambarrukmo.fragment

import android.graphics.drawable.DrawableContainer
import android.opengl.Matrix
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.bumptech.glide.Glide
import com.example.ambarrukmo.R
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.api.DataManager
import com.example.ambarrukmo.databinding.FragmentMapBinding
import com.example.ambarrukmo.dialog.DilaogMapFragment
import com.example.ambarrukmo.viewmodel.product.ProductViewModel
import com.example.ambarrukmo.viewmodel.product.result.LevelFloorItem
import okhttp3.MultipartBody

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MapFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MapFragment : Fragment(), AdapterView.OnItemSelectedListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentMapBinding? = null
    private val binding get() = _binding!!

    var floor = "LG"

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
        _binding = FragmentMapBinding.inflate(layoutInflater, container, false)
//        setDialog()
        setSpinner()
        setDialog()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        floor = "LG"
        setData(
            floor
        )
    }

    private fun setData(floor: String) {
        val formBuilder = MultipartBody.Builder()
        formBuilder.setType(MultipartBody.FORM)
        formBuilder.addFormDataPart("floor_code", floor)
        val formBody = formBuilder.build()
        productViewModel.getLevelFloorData(formBody).observe(requireActivity()){
            when(it){
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
                    getdata(it)
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun getdata(data: ApiCallback.OnSuccess<LevelFloorItem>) {
        Glide.with(requireContext()).load(data.data?.first()?.floor_image).into(binding.imageMaps)
    }

    private fun setDialog() {
        binding.btnInfo.setOnClickListener {
            val dialog = DilaogMapFragment()
            dialog.show(requireFragmentManager(), dialog.tag)
        }
    }

    private fun setSpinner() {
        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.floor,
            android.R.layout.simple_spinner_item
        ). also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerFloor.adapter = adapter
            binding.spinnerFloor.onItemSelectedListener = this
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(position){
            0 -> {
                floor = "LG"
                DataManager.getInstance().floormap = floor
                Log.e("TAG", "Floor: ${DataManager.getInstance().floormap}")
                setData(floor)
            }
            1 ->{
                floor = "GF"
                DataManager.getInstance().floormap = floor
                Log.e("TAG", "Floor: ${DataManager.getInstance().floormap}")
                setData(floor)
            }
            2 ->{
                floor = "L1"
                DataManager.getInstance().floormap = floor
                Log.e("TAG", "Floor: ${DataManager.getInstance().floormap}")
                setData(floor)
            }
            3 -> {
                floor = "L2"
                DataManager.getInstance().floormap = floor
                Log.e("TAG", "Floor: ${DataManager.getInstance().floormap}")
                setData(floor)
            }
            4 -> {
                floor = "L3"
                DataManager.getInstance().floormap = floor
                Log.e("TAG", "Floor: ${DataManager.getInstance().floormap}")
                setData(floor)
            }
            5 -> {
                floor = "L3A"
                DataManager.getInstance().floormap = floor
                Log.e("TAG", "Floor: ${DataManager.getInstance().floormap}")
                setData(floor)
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MapFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MapFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}