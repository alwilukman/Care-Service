package org.d3ifcool.careservice.fragment.datakendaraan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3ifcool.careservice.firebase.datakendaraan.DataKendaraanDao
import org.d3ifcool.careservice.firebase.datakendaraan.DataKendaraanEntities

class DataKendaraanViewModel (private val db: DataKendaraanDao) : ViewModel() {

    fun simpanDatakendaraan(newHistory: DataKendaraanEntities) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(newHistory)
            }
        }
    }
}