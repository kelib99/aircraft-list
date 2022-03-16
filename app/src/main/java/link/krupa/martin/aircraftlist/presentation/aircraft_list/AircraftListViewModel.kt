package link.krupa.martin.aircraftlist.presentation.aircraft_list

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import link.krupa.martin.aircraftlist.common.Resource
import link.krupa.martin.aircraftlist.domain.use_case.get_aircraft_list.GetAircraftListUseCase
import link.krupa.martin.aircraftlist.presentation.common.getContext
import javax.inject.Inject

@HiltViewModel
class AircraftListViewModel @Inject constructor(
    app : Application,
    private val getAircraftListUseCase: GetAircraftListUseCase
) : AndroidViewModel(app) {

    private val _state = mutableStateOf(AircraftListState())
    val state: State<AircraftListState> = _state

    init {
        getAircraftList()
    }

    private fun getAircraftList() {
        getAircraftListUseCase(getContext()).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = AircraftListState(aircraftList = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = AircraftListState(error = result.message ?: "")
                }
                is Resource.Loading -> {
                    _state.value = AircraftListState(isLoading =  true)
                }

                is Resource.Offline -> {
                    //TODO offline state
                }
            }
        }.launchIn(viewModelScope)
    }
}