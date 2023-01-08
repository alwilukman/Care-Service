package org.d3ifcool.careservice.firebase.suzukisite

import androidx.lifecycle.LiveData
import com.google.firebase.database.FirebaseDatabase
import org.d3ifcool.careservice.firebase.dealer.DealerDao
import org.d3ifcool.careservice.firebase.dealer.DealerEntities
import org.d3ifcool.careservice.firebase.dealer.DealerLiveData
import org.d3ifcool.careservice.firebase.suzukihome.SuzukiHomeDb

class SuzukiSiteDb private constructor () {
    private val suzukisitePath = FirebaseDatabase.getInstance()
        .getReference(SUZUKISITE)

    val dao = object : DealerDao {
        override fun getData(): LiveData<List<DealerEntities>> {
            return DealerLiveData(suzukisitePath)
        }

    }

    companion object {
        private const val SUZUKISITE = "suzuki-site"

        @Volatile
        private var INSTANCE: SuzukiSiteDb? = null

        fun getInstance(): SuzukiSiteDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = SuzukiSiteDb()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}