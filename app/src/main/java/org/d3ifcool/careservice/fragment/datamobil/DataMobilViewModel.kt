package org.d3ifcool.careservice.fragment.datamobil

import androidx.lifecycle.ViewModel
import org.d3ifcool.careservice.firebase.datakendaraan.DataKendaraanDao

class DataMobilViewModel (private val db: DataKendaraanDao) : ViewModel() {

    val data = db.getDataKendaraan()
    fun deletebook(id: String){
        db.delete(id)
    }
}