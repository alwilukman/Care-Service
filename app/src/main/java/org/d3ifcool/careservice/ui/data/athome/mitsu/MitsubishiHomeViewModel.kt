package org.d3ifcool.careservice.ui.data.athome.mitsu

import androidx.lifecycle.ViewModel
import org.d3ifcool.careservice.firebase.dealer.DealerDao

class MitsubishiHomeViewModel  (private val db: DealerDao) : ViewModel() {

    val data = db.getData()

}