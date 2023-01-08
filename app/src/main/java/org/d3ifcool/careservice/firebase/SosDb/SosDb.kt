package org.d3ifcool.careservice.firebase.SosDb

import androidx.lifecycle.LiveData
import com.google.firebase.database.FirebaseDatabase
import org.d3ifcool.careservice.firebase.ArtikelDb.ArtikelDao
import org.d3ifcool.careservice.firebase.ArtikelDb.ArtikelDb
import org.d3ifcool.careservice.firebase.ArtikelDb.ArtikelEntities
import org.d3ifcool.careservice.firebase.ArtikelDb.ArtikelLiveData

class SosDb private constructor () {
    private val sosPath = FirebaseDatabase.getInstance()
        .getReference(EMERGENCY)

    val dao = object : SosDao {
        override fun getData(): LiveData<List<SosEntities>> {
            return SosLiveData(sosPath)
        }

    }

    companion object {
        private const val EMERGENCY = "sos"

        @Volatile
        private var INSTANCE: SosDb? = null

        fun getInstance(): SosDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = SosDb()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}