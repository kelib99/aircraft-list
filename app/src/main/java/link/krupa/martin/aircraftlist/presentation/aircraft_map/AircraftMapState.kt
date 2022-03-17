package link.krupa.martin.aircraftlist.presentation.aircraft_map

import com.google.maps.android.compose.MapProperties
import link.krupa.martin.aircraftlist.domain.model.Aircraft

data class AircraftMapState(
    val properties : MapProperties = MapProperties(),
    val aircraftWithShowedInfoWindow : Aircraft? = null
)
