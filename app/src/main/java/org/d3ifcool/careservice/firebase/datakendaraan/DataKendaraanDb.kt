package org.d3ifcool.careservice.firebase.datakendaraan

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class DataKendaraanDb private constructor () {

    private val datakendaraanPath = FirebaseDatabase.getInstance()
        .getReference(DATAKENDARAAN + "/" + FirebaseAuth.getInstance().currentUser!!.uid)

    val dao = object : DataKendaraanDao {

        override fun insert(history: DataKendaraanEntities) {
            datakendaraanPath.push().setValue(history)
        }

        override fun getDataKendaraan(): LiveData<List<DataKendaraanEntities>> {
            return DataKendaraanLiveData(datakendaraanPath)
        }

        override fun delete(id: String){
            datakendaraanPath.child(id).removeValue()
        }

    }

    companion object {

        private const val DATAKENDARAAN = "datakendaraan"

        @Volatile
        private var INSTANCE: DataKendaraanDb? = null

        fun getInstance(): DataKendaraanDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = DataKendaraanDb()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}