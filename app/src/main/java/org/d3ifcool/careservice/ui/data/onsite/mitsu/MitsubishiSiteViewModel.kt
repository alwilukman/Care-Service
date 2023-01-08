package org.d3ifcool.careservice.ui.data.onsite.mitsu

import androidx.lifecycle.ViewModel
import org.d3ifcool.careservice.firebase.dealer.DealerDao

class MitsubishiSiteViewModel (private val db: DealerDao) : ViewModel() {

    val data = db.getData()

}