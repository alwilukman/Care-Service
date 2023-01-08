package org.d3ifcool.careservice.firebase.toyotahome

import androidx.lifecycle.LiveData
import com.google.firebase.database.FirebaseDatabase
import org.d3ifcool.careservice.firebase.dealer.DealerDao
import org.d3ifcool.careservice.firebase.dealer.DealerEntities
import org.d3ifcool.careservice.firebase.dealer.DealerLiveData


class ToyotaHomeDb private constructor () {
    private val toyotahomePath = FirebaseDatabase.getInstance()
        .getReference(TOYOTAHOME)

    val dao = object : DealerDao {
        override fun getData(): LiveData<List<DealerEntities>> {
            return DealerLiveData(toyotahomePath)
        }

    }

    companion object {
        private const val TOYOTAHOME = "toyota-home"

        @Volatile
        private var INSTANCE: ToyotaHomeDb? = null

        fun getInstance(): ToyotaHomeDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = ToyotaHomeDb()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}