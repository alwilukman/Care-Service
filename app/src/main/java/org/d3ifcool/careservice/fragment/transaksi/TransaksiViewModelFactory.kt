package org.d3ifcool.careservice.fragment.transaksi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3ifcool.careservice.firebase.transaksi.TransaksiDao

class TransaksiViewModelFactory(private val db: TransaksiDao) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransaksiViewModel::class.java)) {
            return TransaksiViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}