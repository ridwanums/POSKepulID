package com.example.ambarrukmo.dialog

import android.content.DialogInterface
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.databinding.FragmentBottomSheetDialogDeleteBinding
import com.example.ambarrukmo.eventbus.EvenBusDelete
import com.example.ambarrukmo.eventbus.EventRefreshEvent
import com.example.ambarrukmo.viewmodel.auth.AuthViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.greenrobot.eventbus.EventBus

class DialogDeleteEmailFragment : BottomSheetDialogFragment() {
    private var _binding : FragmentBottomSheetDialogDeleteBinding? = null
    private val binding get() = _binding!!

    private val authViewModel: AuthViewModel by viewModels {
        InjectorUtils.ProviderAuthFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBottomSheetDialogDeleteBinding.inflate(inflater, container, false)
        setEvent()
        return binding.root
    }

    private fun setEvent() {
        binding.btnTextCancel.setOnClickListener {
            this.dismiss()
        }

        binding.btnTextDelete.setOnClickListener {
            val dateText = ""
            EventBus.getDefault().post(EvenBusDelete(dateText))
            this.dismiss()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        EventBus.getDefault().post(EventRefreshEvent())
    }
}