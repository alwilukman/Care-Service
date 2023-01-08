package org.d3ifcool.careservice.ui.sos

import androidx.lifecycle.ViewModel
import org.d3ifcool.careservice.firebase.SosDb.SosDao

class SosViewModel (private val db: SosDao) : ViewModel() {

    val data = db.getData()

}