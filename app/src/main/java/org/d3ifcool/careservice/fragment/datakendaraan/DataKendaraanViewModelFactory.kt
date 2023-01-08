package org.d3ifcool.careservice.fragment.datakendaraan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3ifcool.careservice.firebase.datakendaraan.DataKendaraanDao

class DataKendaraanViewModelFactory(private val db: DataKendaraanDao) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DataKendaraanViewModel::class.java)) {
            return DataKendaraanViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}