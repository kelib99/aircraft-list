package link.krupa.martin.aircraftlist.presentation.aircraft_list

import link.krupa.martin.aircraftlist.domain.model.Aircraft

data class AircraftListState(
    val isLoading : Boolean = false,
    val aircraftList : List<Aircraft>? = null,
    val error : String = ""
)
