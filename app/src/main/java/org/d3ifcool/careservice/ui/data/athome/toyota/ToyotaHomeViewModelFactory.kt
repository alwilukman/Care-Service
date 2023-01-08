package org.d3ifcool.careservice.ui.data.athome.toyota

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3ifcool.careservice.firebase.dealer.DealerDao
import org.d3ifcool.careservice.ui.data.athome.suzuki.SuzukiHomeViewModel

class ToyotaHomeViewModelFactory (private val dbDealer: DealerDao): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(ToyotaHomeViewModel::class.java)) {
            return ToyotaHomeViewModel(dbDealer) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}