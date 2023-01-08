package org.d3ifcool.careservice.fragment.transaksi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3ifcool.careservice.firebase.transaksi.TransaksiDao
import org.d3ifcool.careservice.firebase.transaksi.TransaksiEntities

class TransaksiViewModel(private val db: TransaksiDao) : ViewModel() {

    fun simpanTransaksi(newHistory: TransaksiEntities) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(newHistory)
            }
        }
    }

}