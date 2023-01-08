package org.d3ifcool.careservice.ui.data.athome.kia

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3ifcool.careservice.firebase.dealer.DealerDao

class KiaHomeViewModelFactory (private val dbDealer: DealerDao): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(KiaHomeViewModel::class.java)) {
            return KiaHomeViewModel(dbDealer) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}