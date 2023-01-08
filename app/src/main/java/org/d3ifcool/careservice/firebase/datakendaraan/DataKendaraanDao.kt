package org.d3ifcool.careservice.firebase.datakendaraan
import androidx.lifecycle.LiveData

interface DataKendaraanDao {

    fun insert(history: DataKendaraanEntities)
    fun getDataKendaraan(): LiveData<List<DataKendaraanEntities>>
    fun delete(id: String)
}