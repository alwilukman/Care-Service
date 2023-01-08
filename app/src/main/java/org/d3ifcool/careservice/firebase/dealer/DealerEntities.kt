package org.d3ifcool.careservice.firebase.dealer

import com.google.firebase.database.Exclude

data class DealerEntities(
    @get: Exclude
    var id: String = "",
    var address: String = "",
    var mail:String = "",
    var message: String = "",
    var nama:String = "",
    var operational:String = "",
    var phone: String = "",
)
enum class ApiStatus2 { LOADING, SUCCESS, FAILED }