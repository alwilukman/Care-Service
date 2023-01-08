package org.d3ifcool.careservice.firebase

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val authState = FirebaseUserLiveData()

}