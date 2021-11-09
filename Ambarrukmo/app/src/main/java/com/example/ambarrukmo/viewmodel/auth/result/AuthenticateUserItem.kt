package com.example.ambarrukmo.viewmodel.auth.result

import com.google.gson.annotations.SerializedName

data class AuthenticateUserItem(
    val activation_code: String,
    val created_at: String,
    val dob: String,
    val email: String,
    val fcm_token: String,
    val gender: String,
    val id: Int,
    val image: String,
    val is_active: Int,
    val is_apply_online: Int,
    val is_suspended: Int,
    val last_login: String,
    val mbr_administrasi: Int,
    val mbr_agama: Int,
    val mbr_alamat: String,
    val mbr_alamat_surat: String,
    val mbr_camat: String,
    val mbr_email: String,
    val mbr_expired: String,
    val mbr_hp: String,
    val mbr_hp2: String,
    val mbr_is_aktif: Int,
    val mbr_jenis_kartu: Int,
    val mbr_jenis_pengenal: Int,
    val mbr_kabupaten: Int,
    val mbr_kode: String,
    val mbr_kode_pos: String,
    val mbr_kode_txt: String,
    val mbr_last_trans: String,
    val mbr_lurah: String,
    val mbr_masa_aktif_pengenal: String,
    val mbr_nama: String,
    val mbr_no_pengenal: String,
    val mbr_pekerjaan: Int,
    val mbr_point: Int,
    val mbr_point_sisa: Int,
    val mbr_provinsi: Int,
    val mbr_sex: String,
    val mbr_tanggal_daftar: String,
    val mbr_tanggal_lahir: String,
    val mbr_telp: String,
    val mbr_tempat_lahir: String,
    val profile: Profile,
    val type: String,
    val updated_at: String
)

data class Profile(
    val address: String,
    val address_2: String,
    val created_at: String,
    val fax: String,
    val fax_alt: String,
    val firstname: String,
    val id: Int,
    val info: String,
    val lastname: String,
    val mobile: String,
    val mobile_alt: String,
    val phone: String,
    val phone_alt: String,
    val updated_at: String,
    val user_id: Int
)