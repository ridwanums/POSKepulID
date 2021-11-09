@file:Suppress("UNCHECKED_CAST")

package co.id.codelabs.thesavia.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ambarrukmo.viewmodel.appconfig.AppConfigRepository
import com.example.ambarrukmo.viewmodel.appconfig.AppConfigViewModel
import com.example.ambarrukmo.viewmodel.auth.AuthRepository
import com.example.ambarrukmo.viewmodel.auth.AuthViewModel
import com.example.ambarrukmo.viewmodel.content.ContentRepository
import com.example.ambarrukmo.viewmodel.content.ContentViewModel
import com.example.ambarrukmo.viewmodel.product.ProductRepository
import com.example.ambarrukmo.viewmodel.product.ProductViewModel
import com.example.ambarrukmo.viewmodel.promo.PromoRepository
import com.example.ambarrukmo.viewmodel.promo.PromoViewModel
import com.example.ambarrukmo.viewmodel.valet.ValetRepository
import com.example.ambarrukmo.viewmodel.valet.ValetViewModel


/**
 * Created by Indra on 7/12/2019.
 * Codelabs Indonesia
 * indra@codelabs.co.id
 */

object InjectorUtils {
    fun ProviderAppConfigWalktroughFactory() : ViewModelProvider.NewInstanceFactory{
        val repository = AppConfigRepository.getInstance()

        return object : ViewModelProvider.NewInstanceFactory(){
            override fun <T : ViewModel> create(modelClass: Class<T>) = AppConfigViewModel(
                repository
            ) as T
        }
    }

    fun ProviderAuthFactory() : ViewModelProvider.NewInstanceFactory{
        val repository = AuthRepository.getInstance()

        return object : ViewModelProvider.NewInstanceFactory(){
            override fun <T : ViewModel> create(modelClass: Class<T>) = AuthViewModel(
                repository
            ) as T
        }
    }

    fun ProvidePromoFactory() : ViewModelProvider.NewInstanceFactory{
        val repository = PromoRepository.getInstance()

        return object : ViewModelProvider.NewInstanceFactory(){
            override fun <T : ViewModel> create(modelClass: Class<T>) = PromoViewModel(
                repository
            ) as T
        }
    }

    fun ProvideValetfactory() : ViewModelProvider.NewInstanceFactory{
        val repository = ValetRepository.getInstance()

        return object : ViewModelProvider.NewInstanceFactory(){
            override fun <T : ViewModel> create(modelClass: Class<T>) = ValetViewModel(
                repository
            ) as T
        }
    }

    fun ProvideProductfactory() : ViewModelProvider.NewInstanceFactory{
        val repository = ProductRepository.getInstance()

        return object : ViewModelProvider.NewInstanceFactory(){
            override fun <T : ViewModel> create(modelClass: Class<T>) = ProductViewModel(
                repository
            ) as T
        }
    }

    fun ProvideContentfactory() : ViewModelProvider.NewInstanceFactory{
        val repository = ContentRepository.getInstance()

        return object : ViewModelProvider.NewInstanceFactory(){
            override fun <T : ViewModel> create(modelClass: Class<T>) = ContentViewModel(
                repository
            ) as T
        }
    }
}