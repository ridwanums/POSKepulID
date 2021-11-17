package com.example.ambarrukmo.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.bumptech.glide.Glide
import com.example.ambarrukmo.R
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.api.DataManager
import com.example.ambarrukmo.databinding.ActivityMyProfileBinding
import com.example.ambarrukmo.dialog.DialogDeleteEmailFragment
import com.example.ambarrukmo.eventbus.EvenBusDelete
import com.example.ambarrukmo.fragment.SettingFragment
import com.example.ambarrukmo.viewmodel.auth.AuthViewModel
import com.example.ambarrukmo.viewmodel.auth.result.AuthenticateUserItem
import okhttp3.MultipartBody
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MyProfileActivity : AppCompatActivity() {
    lateinit var binding : ActivityMyProfileBinding


    private val authViewModel: AuthViewModel by viewModels {
        InjectorUtils.ProviderAuthFactory()
    }

    lateinit var authenticateUserItem: AuthenticateUserItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        setEvent()
    }

    private fun setData() {
        authViewModel.getAuthenticeUserData().observe(this){
            when(it) {
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
                    it.data?.let { it1 -> getData(it1) }
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getData(data: AuthenticateUserItem) {
        authenticateUserItem = data
        Glide.with(this)
            .load(data.image)
            .error(R.drawable.no_image)
            .into(binding.imageProfile)
        binding.textName.text = data.mbr_nama
        binding.textEmailInput.setText(data.email)
        binding.textNumberInput.text = data.mbr_hp
        binding.textPasswordInput.text = "1234"
    }

    private fun setEvent() {
        binding.btnEdit.setOnClickListener {
            val edit = Intent(this, EditProfileActivity::class.java)
            startActivity(edit)
        }

        binding.btnFacebook.setOnClickListener {
            Toast.makeText(this, "On Develop :)", Toast.LENGTH_LONG).show()
        }

        binding.btnDeleteEmail.setOnClickListener {
            val dialog = DialogDeleteEmailFragment()
            dialog.show(supportFragmentManager, "TAG")
        }

        binding.btnTextAddEmail.setOnClickListener {
            getAddEmail()
        }

        binding.btnBack.setOnClickListener {
            val back = Intent(this, MainActivity::class.java)
            startActivity(back)
        }

    }

    private fun getAddEmail() {
        val formBuilder = MultipartBody.Builder()
        formBuilder.setType(MultipartBody.FORM)
        formBuilder.addFormDataPart("email", binding.textEmailInput.text.toString().trim())
        formBuilder.addFormDataPart("firstname", authenticateUserItem.profile.firstname)
        formBuilder.addFormDataPart("gender", authenticateUserItem.gender)
        formBuilder.addFormDataPart("dob", authenticateUserItem.dob)
        formBuilder.addFormDataPart("address", authenticateUserItem.profile.address)
        formBuilder.addFormDataPart("ktp_no", authenticateUserItem.mbr_no_pengenal)

        val formBody = formBuilder.build()
        authViewModel.getUpdateProfileData(formBody).observe(this){
            when(it) {
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
                    Toast.makeText(this, "Add Email Success", Toast.LENGTH_LONG).show()
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventDelete(data : EvenBusDelete){
        binding.textEmailInput.setText(data.data)
    }
}