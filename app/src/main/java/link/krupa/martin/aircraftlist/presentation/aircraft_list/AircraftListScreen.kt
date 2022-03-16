package link.krupa.martin.aircraftlist.presentation.aircraft_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import link.krupa.martin.aircraftlist.domain.model.Aircraft
import link.krupa.martin.aircraftlist.presentation.aircraft_list.components.AircraftListItem
import link.krupa.martin.aircraftlist.presentation.ui.theme.spacing

@Composable
fun AircraftListScreen(
    viewModel: AircraftListViewModel = hiltViewModel(),
    onItemClick : (Aircraft) -> Unit
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(state.aircraftList ?: emptyList()) { aircraft ->
                AircraftListItem(
                    aircraft = aircraft,
                    onItemClick = {
                        onItemClick(aircraft)
                    })
            }

        }
        if (state.error.isNotBlank()) {
            Text(text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.spacing.medium)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}