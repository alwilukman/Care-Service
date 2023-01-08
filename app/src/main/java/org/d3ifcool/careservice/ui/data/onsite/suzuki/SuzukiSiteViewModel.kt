package org.d3ifcool.careservice.ui.data.onsite.suzuki

import androidx.lifecycle.ViewModel
import org.d3ifcool.careservice.firebase.dealer.DealerDao

class SuzukiSiteViewModel (private val db: DealerDao) : ViewModel() {

    val data = db.getData()

}