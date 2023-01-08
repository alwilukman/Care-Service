package org.d3ifcool.careservice.firebase.datakendaraan

import com.google.firebase.database.Exclude

data class DataKendaraanEntities(
    @get: Exclude
    var id: String = "",
    var dealer: String = "",
    var jenis: String = "",
    var nomesin: String = "",
    var nopol: String = "",
    var tipemobil: String = "",
    var kilometer: String = "",
    var stnk: String = "",
)