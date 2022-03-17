package link.krupa.martin.aircraftlist.presentation.aircraft_map

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AircraftMapViewModel
    : ViewModel() {
        var state = mutableStateOf(AircraftMapState())
}