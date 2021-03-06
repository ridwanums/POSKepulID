package com.example.ambarrukmo.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ambarrukmo.R
import com.example.ambarrukmo.SplashScreenActivity
import com.example.ambarrukmo.activity.*
import com.example.ambarrukmo.api.DataManager
import com.example.ambarrukmo.databinding.FragmentSettingBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentSettingBinding? = null
    private val binding get() =  _binding!!

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
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        setListener()
        return binding.root
    }

    private fun setListener() {
        binding.textLogout.setOnClickListener {
            val out = Intent(context, SplashScreenActivity::class.java)
            DataManager.getInstance().isLogin = false
            startActivity(out)
        }

        binding.textMyProfile.setOnClickListener {
            val profile = Intent(context, MyProfileActivity::class.java)
            startActivity(profile)
        }

        binding.textAbout.setOnClickListener {
            val about = Intent(context, AboutPascActivity::class.java)
            startActivity(about)
        }

        binding.textFaq.setOnClickListener {
            val faq = Intent(context, FaqActivity::class.java)
            startActivity(faq)
        }

        binding.textContact.setOnClickListener {
            val contact = Intent(context, ContactActivity::class.java)
            startActivity(contact)
        }

        binding.textTerm.setOnClickListener {
            val term = Intent(context, TermOfUseActivity::class.java)
            startActivity(term)
        }

        binding.textPrivacy.setOnClickListener {
            val police = Intent(context, PrivacyPoliceActivity::class.java)
            startActivity(police)
        }

        binding.textLocation.setOnClickListener {
            val location = Intent(context, SelectMapActivity::class.java)
            startActivity(location)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}