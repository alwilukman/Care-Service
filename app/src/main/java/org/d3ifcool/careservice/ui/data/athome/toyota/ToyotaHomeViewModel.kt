package org.d3ifcool.careservice.ui.data.athome.toyota

import androidx.lifecycle.ViewModel
import org.d3ifcool.careservice.firebase.dealer.DealerDao

class ToyotaHomeViewModel (private val db: DealerDao) : ViewModel() {

    val data = db.getData()

}