package link.krupa.martin.aircraftlist.presentation.aircraft_map

import androidx.activity.compose.BackHandler
import link.krupa.martin.aircraftlist.presentation.aircraft_list.AircraftListViewModel


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AircraftMapScreen(
    viewModel: AircraftListViewModel = hiltViewModel(), 
    onBackPressed : () -> Unit
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Mapa")
        BackHandler(true) {
            onBackPressed()
        }
    }
}