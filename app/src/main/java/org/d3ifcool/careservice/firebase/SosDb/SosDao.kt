package org.d3ifcool.careservice.firebase.SosDb

import androidx.lifecycle.LiveData
import org.d3ifcool.careservice.firebase.ArtikelDb.ArtikelEntities

interface SosDao {
    fun getData(): LiveData<List<SosEntities>>
}