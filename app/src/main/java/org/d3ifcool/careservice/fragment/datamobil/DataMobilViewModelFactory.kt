package org.d3ifcool.careservice.fragment.datamobil

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3ifcool.careservice.firebase.datakendaraan.DataKendaraanDao
import org.d3ifcool.careservice.firebase.dealer.DealerDao

class DataMobilViewModelFactory(private val dbDataKendaraan: DataKendaraanDao): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(DataMobilViewModel::class.java)) {
            return DataMobilViewModel(dbDataKendaraan) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}