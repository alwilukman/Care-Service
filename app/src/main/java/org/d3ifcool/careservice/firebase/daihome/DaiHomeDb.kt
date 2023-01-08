package org.d3ifcool.careservice.firebase.daihome

import androidx.lifecycle.LiveData
import com.google.firebase.database.FirebaseDatabase
import org.d3ifcool.careservice.firebase.dealer.DealerDao
import org.d3ifcool.careservice.firebase.dealer.DealerEntities
import org.d3ifcool.careservice.firebase.dealer.DealerLiveData
import org.d3ifcool.careservice.firebase.mitsuhome.MitshuHomeDb

class DaiHomeDb private constructor () {
    private val daihomePath = FirebaseDatabase.getInstance()
        .getReference(DAIHOME)

    val dao = object : DealerDao {
        override fun getData(): LiveData<List<DealerEntities>> {
            return DealerLiveData(daihomePath)
        }

    }

    companion object {
        private const val DAIHOME = "dai-home"

        @Volatile
        private var INSTANCE: DaiHomeDb? = null

        fun getInstance(): DaiHomeDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = DaiHomeDb()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}