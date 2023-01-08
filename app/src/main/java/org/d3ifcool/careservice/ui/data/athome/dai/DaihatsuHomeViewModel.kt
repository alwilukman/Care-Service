package org.d3ifcool.careservice.ui.data.athome.dai

import androidx.lifecycle.ViewModel
import org.d3ifcool.careservice.firebase.dealer.DealerDao

class DaihatsuHomeViewModel  (private val db: DealerDao) : ViewModel() {

    val data = db.getData()

}