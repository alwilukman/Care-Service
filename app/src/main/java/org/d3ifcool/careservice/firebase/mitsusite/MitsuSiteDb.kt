package org.d3ifcool.careservice.firebase.mitsusite

import androidx.lifecycle.LiveData
import com.google.firebase.database.FirebaseDatabase
import org.d3ifcool.careservice.firebase.dealer.DealerDao
import org.d3ifcool.careservice.firebase.dealer.DealerEntities
import org.d3ifcool.careservice.firebase.dealer.DealerLiveData
import org.d3ifcool.careservice.firebase.suzukihome.SuzukiHomeDb

class MitsuSiteDb private constructor () {
    private val mitsusitePath = FirebaseDatabase.getInstance()
        .getReference(MITSUSITE)

    val dao = object : DealerDao {
        override fun getData(): LiveData<List<DealerEntities>> {
            return DealerLiveData(mitsusitePath)
        }

    }

    companion object {
        private const val MITSUSITE = "mitsu-site"

        @Volatile
        private var INSTANCE: MitsuSiteDb? = null

        fun getInstance(): MitsuSiteDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = MitsuSiteDb()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}