package link.krupa.martin.aircraftlist.presentation.aircraft_map

import androidx.activity.compose.BackHandler
import link.krupa.martin.aircraftlist.presentation.common.AircraftListViewModel


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import link.krupa.martin.aircraftlist.R
import link.krupa.martin.aircraftlist.utils.BitmapUtils

@Composable
fun AircraftMapScreen(
    sharedListViewModel: AircraftListViewModel = hiltViewModel(),
    mapViewModel: AircraftMapViewModel = hiltViewModel(),
    onBackPressed: () -> Unit
) {
    val aircraftState = sharedListViewModel.state.value
    val mapState = mapViewModel.state.value
    val uiSettings = remember { MapUiSettings() }
    BackHandler {
        onBackPressed()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val cameraPositionState = rememberCameraPositionState()
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            properties = mapState.properties,
            uiSettings = uiSettings,
            cameraPositionState = cameraPositionState

        ) {

            val planeMarker = BitmapUtils.vectorToBitmap(
                LocalContext.current,
                R.drawable.ic_airplane,
                MaterialTheme.colors.primaryVariant.toArgb()
            )

            aircraftState.aircraftList?.forEach { aircraft ->
                aircraft.latitude?.let { lat ->
                    aircraft.longitude?.let { lon ->
                        Marker(
                            position = LatLng(lat, lon),
                            icon = planeMarker,
                            rotation = aircraft.trueTrack?.toFloat() ?: 0F,
                            title = aircraft.callsign,
                            snippet = "${LocalContext.current.getString(R.string.origin_country)}${aircraft.originCountry}"
                        ) {
                        }
                    }
                }
            }
        }
    }
}
