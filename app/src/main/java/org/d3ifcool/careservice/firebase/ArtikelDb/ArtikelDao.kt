package org.d3ifcool.careservice.firebase.ArtikelDb

import androidx.lifecycle.LiveData

interface ArtikelDao {
    fun getData(): LiveData<List<ArtikelEntities>>
}