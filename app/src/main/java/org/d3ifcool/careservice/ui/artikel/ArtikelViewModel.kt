package org.d3ifcool.careservice.ui.artikel

import androidx.lifecycle.ViewModel
import org.d3ifcool.careservice.firebase.ArtikelDb.ArtikelDao

class ArtikelViewModel (private val db: ArtikelDao) : ViewModel() {

    val data = db.getData()

}