package org.d3ifcool.careservice.fragment.activity

import androidx.lifecycle.ViewModel
import org.d3ifcool.careservice.firebase.transaksi.TransaksiDao

class ActivityViewModel (private val db: TransaksiDao) : ViewModel() {

    val data = db.getTransaksi()
    fun deletebook(id: String){
        db.delete(id)
    }
}