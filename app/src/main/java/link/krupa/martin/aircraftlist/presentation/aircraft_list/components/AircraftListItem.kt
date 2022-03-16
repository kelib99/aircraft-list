package link.krupa.martin.aircraftlist.presentation.aircraft_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import link.krupa.martin.aircraftlist.R
import link.krupa.martin.aircraftlist.domain.model.Aircraft
import link.krupa.martin.aircraftlist.presentation.ui.theme.spacing

@Composable
fun AircraftListItem(
    aircraft: Aircraft,
    onItemClick : (Aircraft) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.medium)
            .clickable { onItemClick(aircraft) },
        horizontalArrangement = Arrangement.SpaceBetween,

    ) {
        Text(
            text = aircraft.callsign ?: stringResource(R.string.NA),
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
    }
}