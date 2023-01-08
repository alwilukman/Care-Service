package org.d3ifcool.careservice.firebase.ArtikelDb

import com.google.firebase.database.Exclude

data class ArtikelEntities(
    @get: Exclude
    var id: String = "",
    var url: String = "",
    var judul: String = "",
    var isi: String = "",
)