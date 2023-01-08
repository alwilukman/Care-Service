package org.d3ifcool.careservice.ui.data.onsite.suzuki

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3ifcool.careservice.firebase.dealer.DealerDao
import org.d3ifcool.careservice.ui.data.onsite.mitsu.MitsubishiSiteViewModel

class SuzukiSiteViewModelFactory (private val dbDealer: DealerDao): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(SuzukiSiteViewModel::class.java)) {
            return SuzukiSiteViewModel(dbDealer) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}