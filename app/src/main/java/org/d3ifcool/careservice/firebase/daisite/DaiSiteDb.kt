package org.d3ifcool.careservice.firebase.daisite

import androidx.lifecycle.LiveData
import com.google.firebase.database.FirebaseDatabase
import org.d3ifcool.careservice.firebase.dealer.DealerDao
import org.d3ifcool.careservice.firebase.dealer.DealerEntities
import org.d3ifcool.careservice.firebase.dealer.DealerLiveData
import org.d3ifcool.careservice.firebase.mitsusite.MitsuSiteDb

class DaiSiteDb private constructor () {
    private val daisitePath = FirebaseDatabase.getInstance()
        .getReference(DAISITE)

    val dao = object : DealerDao {
        override fun getData(): LiveData<List<DealerEntities>> {
            return DealerLiveData(daisitePath)
        }

    }

    companion object {
        private const val DAISITE = "dai-site"

        @Volatile
        private var INSTANCE: DaiSiteDb? = null

        fun getInstance(): DaiSiteDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = DaiSiteDb()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}