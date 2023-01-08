package org.d3ifcool.careservice.firebase.toyotasite

import androidx.lifecycle.LiveData
import com.google.firebase.database.FirebaseDatabase
import org.d3ifcool.careservice.firebase.dealer.DealerDao
import org.d3ifcool.careservice.firebase.dealer.DealerEntities
import org.d3ifcool.careservice.firebase.dealer.DealerLiveData
import org.d3ifcool.careservice.firebase.toyotahome.ToyotaHomeDb

class ToyotaSiteDb private constructor () {
    private val toyotasitePath = FirebaseDatabase.getInstance()
        .getReference(TOYOTASITE)

    val dao = object : DealerDao {
        override fun getData(): LiveData<List<DealerEntities>> {
            return DealerLiveData(toyotasitePath)
        }

    }

    companion object {
        private const val TOYOTASITE = "toyota-site"

        @Volatile
        private var INSTANCE: ToyotaSiteDb? = null

        fun getInstance(): ToyotaSiteDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = ToyotaSiteDb()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}