package org.d3ifcool.careservice.ui

import androidx.lifecycle.ViewModel
import org.d3ifcool.careservice.firebase.FirebaseUserLiveData

class ProfileViewModel : ViewModel() {

    val authState = FirebaseUserLiveData()

}