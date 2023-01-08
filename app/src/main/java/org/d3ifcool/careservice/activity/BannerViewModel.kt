package org.d3ifcool.careservice.activity

import androidx.lifecycle.ViewModel
import org.d3ifcool.careservice.firebase.FirebaseUserLiveData

class BannerViewModel : ViewModel() {

    val authState = FirebaseUserLiveData()

}