package org.d3ifcool.careservice.firebase.transaksi

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class TransaksiDb private constructor () {
    private val transaksiPath = FirebaseDatabase.getInstance()
        .getReference(TRANSAKSI + "/" + FirebaseAuth.getInstance().currentUser!!.uid)

    val dao = object : TransaksiDao {

        override fun insert(history: TransaksiEntities) {
            transaksiPath.push().setValue(history)
        }

        override fun getTransaksi(): LiveData<List<TransaksiEntities>> {
            return TransaksiLiveData(transaksiPath)
        }

        override fun delete(id: String){
            transaksiPath.child(id).removeValue()
        }

    }

    companion object {
        private const val TRANSAKSI = "transaksi"

        @Volatile
        private var INSTANCE: TransaksiDb? = null

        fun getInstance(): TransaksiDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = TransaksiDb()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}