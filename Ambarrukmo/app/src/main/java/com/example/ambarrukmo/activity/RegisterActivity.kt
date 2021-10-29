package com.example.ambarrukmo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.databinding.ActivityRegisterBinding
import com.example.ambarrukmo.viewmodel.auth.AuthViewModel
import okhttp3.MultipartBody

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private val authViewModel : AuthViewModel by viewModels {
        InjectorUtils.ProviderAuthFactory()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setEven()
    }

    private fun setEven() {
        binding.imageClose.setOnClickListener {
            onBackPressed()
        }

        binding.btnRegister.setOnClickListener {
            if (binding.checkbox.isChecked){
                setRegister()
            }
        }
    }

    private fun setRegister() {
        val formbuilder = MultipartBody.Builder()
        formbuilder.setType(MultipartBody.FORM)
        formbuilder.addFormDataPart("email", binding.textInputEmail.text.toString().trim())
        formbuilder.addFormDataPart("password", binding.textInputPassword.text.toString().trim())
        formbuilder.addFormDataPart("password_confirmation", binding.textInputCpassword.text.toString().trim())
        formbuilder.addFormDataPart("firstname", binding.textInputFirst.text.toString().trim())
        formbuilder.addFormDataPart("lastname", binding.textInputLast.text.toString().trim())
        formbuilder.addFormDataPart("phone_no", binding.textInputNohp.text.toString().trim())
        formbuilder.addFormDataPart("gender", "male")
        formbuilder.addFormDataPart("dob", "1995-11-03")
        val formBody = formbuilder.build()
        authViewModel.getRegisterData(formBody).observe(this){
            when(it){
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
                    onBackPressed()
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()

                }
            }
        }
    }
}