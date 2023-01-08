package org.d3ifcool.careservice.firebase.transaksi

import com.google.firebase.database.Exclude

data class TransaksiEntities (
    @get: Exclude
    var id: String = "",
    var dealer: String = "",
    var status: String = "",
    var alamat: String = "",
    var paket: String = "",
    var jam: String = "",
    var jadwal: String = "",
    var keluhan: String = "",
)