package com.codelabs.poskepulid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codelabs.poskepulid.databinding.ActivityVerifikasiOtpactivityBinding
import com.codelabs.poskepulid.helper.EditTextUtils

class VerifikasiOTPActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerifikasiOtpactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifikasiOtpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.code1.addTextChangedListener(EditTextUtils.getTextWatcher(binding.code1, binding.code2, false))
        binding.code2.addTextChangedListener(EditTextUtils.getTextWatcher(binding.code2, binding.code3, false))
        binding.code3.addTextChangedListener(EditTextUtils.getTextWatcher(binding.code3, binding.code4, false))
        binding.code4.addTextChangedListener(EditTextUtils.getTextWatcher(binding.code4, null, true))

        binding.code1.setOnKeyListener(EditTextUtils.onClickDelete(null, binding.code1, true))
        binding.code2.setOnKeyListener(EditTextUtils.onClickDelete(binding.code1, binding.code2, false))
        binding.code3.setOnKeyListener(EditTextUtils.onClickDelete(binding.code2, binding.code3, false))
        binding.code4.setOnKeyListener(EditTextUtils.onClickDelete(binding.code3, binding.code4, false))
    }
}