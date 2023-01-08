package org.d3ifcool.careservice.firebase.dealer

import androidx.lifecycle.LiveData

interface DealerDao  {
    fun getData(): LiveData<List<DealerEntities>>
}