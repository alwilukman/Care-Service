package org.d3ifcool.careservice.ui.data.athome.suzuki

import androidx.lifecycle.ViewModel
import org.d3ifcool.careservice.firebase.dealer.DealerDao

class SuzukiHomeViewModel (private val db: DealerDao) : ViewModel() {

    val data = db.getData()

}