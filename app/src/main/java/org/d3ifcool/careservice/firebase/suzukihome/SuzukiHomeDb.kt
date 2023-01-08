package org.d3ifcool.careservice.firebase.suzukihome

import androidx.lifecycle.LiveData
import com.google.firebase.database.FirebaseDatabase
import org.d3ifcool.careservice.firebase.dealer.DealerDao
import org.d3ifcool.careservice.firebase.dealer.DealerEntities
import org.d3ifcool.careservice.firebase.dealer.DealerLiveData
import org.d3ifcool.careservice.firebase.mitsuhome.MitshuHomeDb

class SuzukiHomeDb private constructor () {
    private val suzukihomePath = FirebaseDatabase.getInstance()
        .getReference(SUZUKIHOME)

    val dao = object : DealerDao {
        override fun getData(): LiveData<List<DealerEntities>> {
            return DealerLiveData(suzukihomePath)
        }

    }

    companion object {
        private const val SUZUKIHOME = "suzuki-home"

        @Volatile
        private var INSTANCE: SuzukiHomeDb? = null

        fun getInstance(): SuzukiHomeDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = SuzukiHomeDb()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}