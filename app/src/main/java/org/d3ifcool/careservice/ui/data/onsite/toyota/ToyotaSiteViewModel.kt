package org.d3ifcool.careservice.ui.data.onsite.toyota

import androidx.lifecycle.ViewModel
import org.d3ifcool.careservice.firebase.dealer.DealerDao

class ToyotaSiteViewModel (private val db: DealerDao) : ViewModel() {

    val data = db.getData()

}