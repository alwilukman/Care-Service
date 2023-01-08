package org.d3ifcool.careservice.ui.data.athome.kia

import androidx.lifecycle.ViewModel
import org.d3ifcool.careservice.firebase.dealer.DealerDao

class KiaHomeViewModel (private val db: DealerDao) : ViewModel() {

    val data = db.getData()
}