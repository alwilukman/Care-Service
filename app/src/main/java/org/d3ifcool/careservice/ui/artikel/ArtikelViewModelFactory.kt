package org.d3ifcool.careservice.ui.artikel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3ifcool.careservice.firebase.ArtikelDb.ArtikelDao

class ArtikelViewModelFactory(private val dbArtikel:ArtikelDao): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(ArtikelViewModel::class.java)) {
            return ArtikelViewModel(dbArtikel) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}