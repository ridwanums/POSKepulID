package com.example.ambarrukmo.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import co.id.codelabs.thesavia.utils.InjectorUtils
import com.example.ambarrukmo.R
import com.example.ambarrukmo.activity.LoginActivity
import com.example.ambarrukmo.adapter.*
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.api.DataManager
import com.example.ambarrukmo.databinding.FragmentHomeBinding
import com.example.ambarrukmo.viewmodel.product.ProductViewModel
import com.example.ambarrukmo.viewmodel.product.result.MerchantCategoriesItem
import com.example.ambarrukmo.viewmodel.promo.PromoViewModel
import com.example.ambarrukmo.viewmodel.promo.result.PromoEventItem
import com.example.ambarrukmo.viewmodel.promo.result.PromotionCategoryItem
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var cardSlider: SliderView? = null
    private var adapter : ImageSliderAdapter? = null

    private val promoViewModel : PromoViewModel by viewModels {
        InjectorUtils.ProvidePromoFactory()
    }

    private val productViewModel : ProductViewModel by viewModels {
        InjectorUtils.ProvideProductfactory()
    }


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
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        setView(view)
        return binding.root
    }

    private fun setView(view: View?) {
        cardSlider = view?.findViewById(R.id.image_item_slide)
        setSlideAdapter()

    }

    override fun onResume() {
        super.onResume()
        setCategories()
        setBanner()
        setPromoCategory()
    }

    private fun setCategories() {
        productViewModel.getMerchantCategoriesData().observe(requireActivity()){
            when(it){
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
                    it.data?.let { it1 -> setProduct(it1) }
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    val out = Intent(requireContext(), LoginActivity::class.java)
                    startActivity(out)
                    DataManager.getInstance().isLogin = false

                }
            }
        }
    }

    @SuppressLint("WrongConstant")
    private fun setProduct(data: MerchantCategoriesItem) {
        binding.reycleCategories.adapter = MerchantCategoriesAdapter(data)
        binding.reycleCategories.layoutManager = LinearLayoutManager(requireContext(), OrientationHelper.HORIZONTAL, false)

    }


    private fun setBanner() {
        promoViewModel.getPromotionEventData().observe(requireActivity()){
            when(it){
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
                    it.data?.let { it1 -> setData(it1) }
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    DataManager.getInstance().isLogin = false

                }
            }
        }
    }

    private fun setData(data: PromoEventItem) {
        adapter = ImageSliderAdapter(data)
        binding.imageHomeBanner.adapter = adapter

    }

    private fun setSlideAdapter() {
        cardSlider?.setSliderAdapter(adapter!!)
        cardSlider?.startAutoCycle()
        cardSlider?.setAutoCycle(true)
        cardSlider?.setIndicatorAnimationDuration(600)
        cardSlider?.setSliderAnimationDuration(600)
        cardSlider?.setScrollTimeInSec(3)
        cardSlider?.setIndicatorAnimation(IndicatorAnimations.SLIDE)
        cardSlider?.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH)
        cardSlider?.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION)
    }

    private fun setPromoCategory() {
        promoViewModel.getPromotionCategoryData().observe(requireActivity()){
            when(it){
                is ApiCallback.OnLoading -> {

                }
                is ApiCallback.OnSuccess -> {
                    it.data?.let { it1 -> getpromoCategory(it1) }
                }
                is ApiCallback.OnError -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    DataManager.getInstance().isLogin = false

                }
            }
        }
    }

    private fun getpromoCategory(data: PromotionCategoryItem) {
        binding.recycleCategoriPromo.adapter = CategoriesHomeAdapter(data)
        binding.recycleCategoriPromo.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}