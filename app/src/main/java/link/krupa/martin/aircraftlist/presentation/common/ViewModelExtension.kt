package link.krupa.martin.aircraftlist.presentation.common

import android.content.Context
import androidx.lifecycle.AndroidViewModel
import link.krupa.martin.aircraftlist.AircraftApplication

fun AndroidViewModel.getContext() : Context{
    return getApplication<AircraftApplication>().applicationContext
}