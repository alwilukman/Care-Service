package org.d3ifcool.careservice.firebase.mitsuhome

import androidx.lifecycle.LiveData
import com.google.firebase.database.FirebaseDatabase
import org.d3ifcool.careservice.firebase.dealer.DealerDao
import org.d3ifcool.careservice.firebase.dealer.DealerEntities
import org.d3ifcool.careservice.firebase.dealer.DealerLiveData
import org.d3ifcool.careservice.firebase.transaksi.TransaksiDb

class MitshuHomeDb private constructor () {
    private val mitshuhomePath = FirebaseDatabase.getInstance()
        .getReference(MITSHUHOME)

    val dao = object : DealerDao {
        override fun getData(): LiveData<List<DealerEntities>> {
            return DealerLiveData(mitshuhomePath)
        }

    }

    companion object {
        private const val MITSHUHOME = "mitshu-home"

        @Volatile
        private var INSTANCE: MitshuHomeDb? = null

        fun getInstance(): MitshuHomeDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = MitshuHomeDb()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}