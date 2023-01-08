package org.d3ifcool.careservice.ui.sos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3ifcool.careservice.firebase.ArtikelDb.ArtikelDao
import org.d3ifcool.careservice.firebase.SosDb.SosDao
import org.d3ifcool.careservice.ui.artikel.ArtikelViewModel

class SosViewModelFactory (private val dbSos: SosDao): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(SosViewModel::class.java)) {
            return SosViewModel(dbSos) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}