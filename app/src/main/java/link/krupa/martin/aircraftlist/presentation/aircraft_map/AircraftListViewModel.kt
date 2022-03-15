package link.krupa.martin.aircraftlist.presentation.aircraft_map

import dagger.hilt.android.lifecycle.HiltViewModel
import link.krupa.martin.aircraftlist.domain.use_case.get_aircraft_list.GetAircraftListUseCase
import javax.inject.Inject

@HiltViewModel
class AircraftListViewModel @Inject constructor(
    private val getAircraftListUseCase: GetAircraftListUseCase
){

}