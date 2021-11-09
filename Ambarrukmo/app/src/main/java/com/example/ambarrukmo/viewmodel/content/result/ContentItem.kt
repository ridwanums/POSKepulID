package com.example.ambarrukmo.viewmodel.content.result

data class ContentItem(
    val contact: Contact,
    val faqs: List<Faq>,
    val privacy_policies: List<PrivacyPolicy>,
    val socmed: Socmed,
    val term_of_uses: List<TermOfUse>
)

data class Contact(
    val address: String,
    val email: String,
    val fax: String,
    val phone_no: String
)

data class Faq(
    val content: String,
    val created_at: String,
    val id: Int,
    val is_active: Int,
    val sequence: Int,
    val title: String,
    val type: Int,
    val updated_at: String
)

data class PrivacyPolicy(
    val content: String,
    val created_at: String,
    val id: Int,
    val is_active: Int,
    val sequence: Int,
    val title: String,
    val type: Int,
    val updated_at: String
)

data class Socmed(
    val facebook: Facebook,
    val instagram: Instagram,
    val twitter: Twitter,
    val youtube: Youtube
)

data class Facebook(
    val name: String,
    val url: String
)

data class Instagram(
    val name: String,
    val url: String
)

data class Twitter(
    val name: String,
    val url: String
)

data class Youtube(
    val name: String,
    val url: String
)

data class TermOfUse(
    val content: String,
    val created_at: String,
    val id: Int,
    val is_active: Int,
    val sequence: Int,
    val title: String,
    val type: Int,
    val updated_at: String
)