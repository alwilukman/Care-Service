package org.d3ifcool.careservice.firebase.ArtikelDb

import androidx.lifecycle.LiveData
import com.google.firebase.database.FirebaseDatabase

class ArtikelDb private constructor () {
    private val artikelePath = FirebaseDatabase.getInstance()
        .getReference(ARTIKELSATU)

    val dao = object : ArtikelDao {
        override fun getData(): LiveData<List<ArtikelEntities>> {
            return ArtikelLiveData(artikelePath)
        }

    }

    companion object {
        private const val ARTIKELSATU = "artikel"

        @Volatile
        private var INSTANCE: ArtikelDb? = null

        fun getInstance(): ArtikelDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = ArtikelDb()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}