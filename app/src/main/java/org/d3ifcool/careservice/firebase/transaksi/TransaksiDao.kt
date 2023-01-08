package org.d3ifcool.careservice.firebase.transaksi

import androidx.lifecycle.LiveData

interface TransaksiDao {

    fun insert(history: TransaksiEntities)
    fun getTransaksi(): LiveData<List<TransaksiEntities>>
    fun delete(id: String)

}