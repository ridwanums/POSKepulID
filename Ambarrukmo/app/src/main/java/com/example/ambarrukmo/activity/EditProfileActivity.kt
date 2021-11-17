package com.example.ambarrukmo.activity

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.ims.ImsManager
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.bumptech.glide.Glide
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.api.DataManager
import com.example.ambarrukmo.databinding.ActivityEditProfileBinding
import com.example.ambarrukmo.viewmodel.auth.AuthViewModel
import com.example.ambarrukmo.viewmodel.auth.result.AuthenticateUserItem
import com.github.dhaval2404.imagepicker.ImagePicker
import okhttp3.MultipartBody

class EditProfileActivity : AppCompatActivity() {
    lateinit var binding : ActivityEditProfileBinding

    private val authViewModel: AuthViewModel by viewModels {
        InjectorUtils.ProviderAuthFactory()
    }

    lateinit var authenticateUserItem: AuthenticateUserItem

    companion object{
        private const val CAMERA_PERMISSION_CODE = 100
        private const val STORAGE_PERMISSION_CODE = 101
        private const val LOCATION_PERMISSION_CODE = 102
    }
    lateinit var bitmap: Bitmap
    var uri : Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
        SetData()
        setCamera()
        setEvent()

        checkPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE)
        checkPermission(
            android.Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)
        checkPermission(
            android.Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_PERMISSION_CODE
        )
    }

    private fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        } else {

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {

            }
        } else if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {

            }
        }
    }

    private fun SetData() {
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

    private fun getData(data: AuthenticateUserItem) {
        binding.textNameFull.setText(data.mbr_nama)
        authenticateUserItem = data
    }

    private fun setCamera() {
        binding.imageProfile.setOnClickListener {
            ImagePicker.with(this)
                .crop()
                .compress(1024)
                .maxResultSize(1080,1080)
                .createIntent { intent -> startForProfileImageResult.launch(intent) }

        }
    }

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                uri = data?.data!!
                bitmap = BitmapFactory.decodeFile(uri?.path)
                binding.imageProfile.setImageBitmap(bitmap)
            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
            } else {
            }
        }

    private fun setEvent() {
        binding.btnSave.setOnClickListener {
            setEdit()
        }

        binding.btnBack.setOnClickListener {
           onBackPressed()
        }

    }

    private fun setEdit() {
        val formBuilder = MultipartBody.Builder()
        formBuilder.setType(MultipartBody.FORM)
        formBuilder.addFormDataPart("email", authenticateUserItem.email)
        formBuilder.addFormDataPart("firstname", binding.textNameFull.text.toString().trim())
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
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    val back = Intent(this, MyProfileActivity::class.java)
                    startActivity(back)
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
