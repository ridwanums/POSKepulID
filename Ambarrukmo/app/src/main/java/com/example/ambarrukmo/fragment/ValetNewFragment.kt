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
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.api.DataManager
import com.example.ambarrukmo.databinding.FragmentValetNewBinding
import com.example.ambarrukmo.dialog.DatePickerFragmentDialog
import com.example.ambarrukmo.dialog.DialogValleyFragment
import com.example.ambarrukmo.dialog.TimePickerFragmentDialog
import com.example.ambarrukmo.viewmodel.valet.ValetViewModel
import com.example.ambarrukmo.viewmodel.valet.result.ValetCreateItem
import com.example.ambarrukmo.viewmodel.valet.result.ValetNumberItem
import okhttp3.MultipartBody
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ValetNewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ValetNewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentValetNewBinding? = null
    private val binding get() = _binding!!

    private val valetViewModel : ValetViewModel by viewModels {
        InjectorUtils.ProvideValetfactory()
    }

    private var datePicker = DatePickerFragmentDialog()
    private var timePicker = TimePickerFragmentDialog()

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
        _binding = FragmentValetNewBinding.inflate(inflater, container, false)

        val time = Calendar.getInstance()
        val hour = time.get(Calendar.HOUR)
        val minute = time.get(Calendar.MINUTE)
        val timeStar = "$hour:$minute"
        binding.textDateEnd.text=timeStar
        binding.layoutDateEnd.setOnClickListener {
            timePicker.setDefaultTime(binding.textDateEnd.text.toString())
            timePicker.show(childFragmentManager, timePicker.tag)
        }

        val date = Calendar.getInstance()
        val year = date.get(Calendar.YEAR)
        val month = date.get(Calendar.MONTH) + 1
        val day = date.get(Calendar.DAY_OF_MONTH)
        val datestart = "$day-$month-$year"
        binding.textDateStart.text = datestart
        binding.layoutDateStart.setOnClickListener {
            datePicker.setDefaultDate(binding.textDateStart.text.toString())
            datePicker.show(childFragmentManager, datePicker.tag)
        }

        setEvent(datestart, timeStar)
        setData()
        setDatePicker()
        setTimePicker()
        return binding.root
    }

    private fun setTimePicker() {

        timePicker.onClick = {
            binding.textDateEnd.text = it
            val formatTime = it
            setEvent("", formatTime)
        }
    }

    private fun setDatePicker() {
        datePicker.onClick = {
            binding.textDateStart.text = it
            val formatDate = it
            setEvent(formatDate, "")
        }
    }


    private fun setData() {
        valetViewModel.getValetNumberData().observe(requireActivity()){
            when(it){
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
                    getData(it)
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun getData(it: ApiCallback.OnSuccess<ValetNumberItem>) {
        DataManager.getInstance().numberValet = it.data?.vallet_number?.toInt()
        binding.textValetNumber.text = it.data?.vallet_number
    }

    private fun setEvent(date:String, time: String) {
        binding.btnBooking.setOnClickListener {
            val formbuilder = MultipartBody.Builder()
            formbuilder.setType(MultipartBody.FORM)
            formbuilder.addFormDataPart("vallet_number", DataManager.getInstance().numberValet.toString())
            formbuilder.addFormDataPart("no_pol", binding.textInputPolice.text.toString())
            formbuilder.addFormDataPart("car_brand", binding.textInputBrand.text.toString())
            formbuilder.addFormDataPart("car_color", binding.textInputColour.text.toString())
            formbuilder.addFormDataPart("car_type", "CRV")
            val formBody = formbuilder.build()
            valetViewModel.getCreateValetData(formBody).observe(requireActivity()){
                when(it){
                    is ApiCallback.OnLoading -> {

                    }
                    is ApiCallback.OnSuccess -> {
                        getCreateValet(it)
                    }
                    is ApiCallback.OnError -> {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                        val dialog = DialogValleyFragment(400, DataManager.getInstance().numberValet.toString())
                        dialog.show(requireFragmentManager(), dialog.tag)
                    }
                }
            }
        }
    }

    private fun getCreateValet(data: ApiCallback.OnSuccess<ValetCreateItem>) {
        val dialog = DialogValleyFragment(200, DataManager.getInstance().numberValet.toString())
        dialog.show(requireFragmentManager(), dialog.tag)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ValetNewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ValetNewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}