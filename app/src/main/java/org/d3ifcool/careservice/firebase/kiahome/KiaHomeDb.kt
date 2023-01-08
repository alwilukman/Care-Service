package org.d3ifcool.careservice.firebase.kiahome

import androidx.lifecycle.LiveData
import com.google.firebase.database.FirebaseDatabase
import org.d3ifcool.careservice.firebase.dealer.DealerDao
import org.d3ifcool.careservice.firebase.dealer.DealerEntities
import org.d3ifcool.careservice.firebase.dealer.DealerLiveData


class KiaHomeDb private constructor () {
    private val kiahomePath = FirebaseDatabase.getInstance()
        .getReference(KIAHOME)

    val dao = object : DealerDao {
        override fun getData(): LiveData<List<DealerEntities>> {
            return DealerLiveData(kiahomePath)
        }

    }

    companion object {
        private const val KIAHOME = "kia-home"

        @Volatile
        private var INSTANCE: KiaHomeDb? = null

        fun getInstance(): KiaHomeDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = KiaHomeDb()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}