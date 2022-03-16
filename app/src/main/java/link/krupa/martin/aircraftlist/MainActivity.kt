package link.krupa.martin.aircraftlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import link.krupa.martin.aircraftlist.common.Constants
import link.krupa.martin.aircraftlist.presentation.aircraft_list.AircraftListScreen
import link.krupa.martin.aircraftlist.presentation.aircraft_list.AircraftListViewModel
import link.krupa.martin.aircraftlist.presentation.ui.theme.AircraftListTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel  by viewModels<AircraftListViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AircraftListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    AircraftListScreen(navController = navController)
                }
            }
        }
        pollApiPeriodically()
    }
    private fun pollApiPeriodically() {
        lifecycleScope.launch() {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                while (true) {
                    viewModel.getAircraftList()
                    delay(Constants.GET_AIRCRAFT_LIST_POLL_PERIOD)
                }
            }
        }
    }

}

