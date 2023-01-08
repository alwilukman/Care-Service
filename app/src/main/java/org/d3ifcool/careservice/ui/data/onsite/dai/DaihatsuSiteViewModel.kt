package org.d3ifcool.careservice.ui.data.onsite.dai

import androidx.lifecycle.ViewModel
import org.d3ifcool.careservice.firebase.dealer.DealerDao

class DaihatsuSiteViewModel (private val db: DealerDao) : ViewModel() {

    val data = db.getData()

}