package org.d3ifcool.careservice.fragment.transaksisite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3ifcool.careservice.firebase.transaksi.TransaksiDao

class TransaksiSiteFragmentViewModelFactory (private val db: TransaksiDao) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransaksiSiteFragmentViewModel::class.java)) {
            return TransaksiSiteFragmentViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}