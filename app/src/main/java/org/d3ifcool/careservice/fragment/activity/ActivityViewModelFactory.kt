package org.d3ifcool.careservice.fragment.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3ifcool.careservice.firebase.transaksi.TransaksiDao

class ActivityViewModelFactory (private val dbTransaksi: TransaksiDao): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(ActivityViewModel::class.java)) {
            return ActivityViewModel(dbTransaksi) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}