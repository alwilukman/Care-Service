package org.d3ifcool.careservice.fragment.transaksisite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3ifcool.careservice.firebase.transaksi.TransaksiDao
import org.d3ifcool.careservice.firebase.transaksi.TransaksiEntities

class TransaksiSiteFragmentViewModel (private val db: TransaksiDao) : ViewModel() {

    fun simpanTransaksiSite(newHistory: TransaksiEntities) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(newHistory)
            }
        }
    }

}