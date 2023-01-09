package com.example.booking_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CabViewModel : ViewModel() {
    private val _from = MutableLiveData<String>()
    val from: LiveData<String> = _from

    private val _to = MutableLiveData<String>()
    val to: LiveData<String> = _to

    private val _vehicle = MutableLiveData<String>()
    val vehicle: LiveData<String> = _vehicle

    init {
        clear()
    }

    fun clear() {
        _from.value = ""
        _to.value = ""
        _vehicle.value = ""
    }

    fun updateInfo(from: String, to: String, vehicle: String): String {
        return when {
            from.isEmpty() -> {
                "from location is empty"
            }
            to.isEmpty() -> {
                "To location is empty"
            }
            else -> {
                _from.value = from
                _to.value = to
                _vehicle.value = vehicle
                "location updated"
            }
        }

    }

}
