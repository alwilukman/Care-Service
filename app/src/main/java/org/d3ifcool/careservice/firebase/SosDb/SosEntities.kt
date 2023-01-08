package org.d3ifcool.careservice.firebase.SosDb

import com.google.firebase.database.Exclude

data class SosEntities (
    @get: Exclude
    var id: String = "",
    var url: String = "",
    var no: String = "",
    var nama: String = "",
    var web: String = "",
)