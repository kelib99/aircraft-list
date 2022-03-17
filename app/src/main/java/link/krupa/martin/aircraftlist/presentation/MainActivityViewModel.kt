package link.krupa.martin.aircraftlist.presentation

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    app: Application
) : AndroidViewModel(app) {

    private val _state = mutableStateOf(MainActivityState())
    val state: State<MainActivityState> = _state

    fun changeTabIndex(newTabIndex: Int) {
        _state.value = MainActivityState(newTabIndex)
    }
}