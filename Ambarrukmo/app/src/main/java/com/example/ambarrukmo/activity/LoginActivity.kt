package com.example.ambarrukmo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.api.DataManager
import com.example.ambarrukmo.databinding.ActivityLoginBinding
import com.example.ambarrukmo.viewmodel.auth.AuthViewModel
import okhttp3.MultipartBody

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding

    private val authViewModel : AuthViewModel by viewModels {
        InjectorUtils.ProviderAuthFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textInputNohp.setText("087886683155")
        binding.textInputPassword.setText("1234")
        binding.imageClose.setOnClickListener {
            onBackPressed()
        }

        binding.btnLogin.setOnClickListener {
            setLogin()
        }
    }

    private fun setLogin() {
        val formbuilder = MultipartBody.Builder()
        formbuilder.setType(MultipartBody.FORM)
        formbuilder.addFormDataPart("platform", "android")
        formbuilder.addFormDataPart("password", binding.textInputPassword.text.toString().trim())
        formbuilder.addFormDataPart("phone_no", binding.textInputNohp.text.toString().trim())
        val formbody = formbuilder.build()
        authViewModel.getLoginData(formbody).observe(this){
            when(it){
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
                    val login = Intent(this, MainActivity::class.java)
                    startActivity(login)
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()

                }
            }
        }
    }
}