package org.d3ifcool.careservice.ui.history

import androidx.lifecycle.ViewModel
import org.d3ifcool.careservice.firebase.transaksi.TransaksiDao

class HistoryViewModel (private val db: TransaksiDao) : ViewModel() {

    val data = db.getTransaksi()
    fun deletebook(id: String){
        db.delete(id)
    }
}