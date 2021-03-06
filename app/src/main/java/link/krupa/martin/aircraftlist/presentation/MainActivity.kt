package link.krupa.martin.aircraftlist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import link.krupa.martin.aircraftlist.R
import link.krupa.martin.aircraftlist.common.Constants
import link.krupa.martin.aircraftlist.presentation.aircraft_list.AircraftListScreen
import link.krupa.martin.aircraftlist.presentation.common.AircraftListViewModel
import link.krupa.martin.aircraftlist.presentation.aircraft_map.AircraftMapScreen
import link.krupa.martin.aircraftlist.presentation.common.components.TabItem
import link.krupa.martin.aircraftlist.presentation.ui.theme.AircraftListTheme
import link.krupa.martin.aircraftlist.presentation.ui.theme.fontSize

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<AircraftListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AircraftListTheme {
                MainScreen()
            }
        }
        pollApiPeriodically()
    }

    private fun pollApiPeriodically() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                while (true) {
                    viewModel.getAircraftList()
                    delay(Constants.GET_AIRCRAFT_LIST_POLL_PERIOD)
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current
    val tabs = listOf(
        TabItem.AircraftList(context),
        TabItem.AircraftMap(context)
    )
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar() },
        backgroundColor = MaterialTheme.colors.background
    ) {
        Tabs(tabs = tabs)

    }

}

@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                fontSize = MaterialTheme.fontSize.large
            )
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    )
}


@Composable
fun Tabs(
    tabs: List<TabItem>,
) {
    Column {
        val viewModel: MainActivityViewModel = viewModel()
        val state = viewModel.state.value
        TabRow(
            selectedTabIndex = state.currentTabIndex,
            backgroundColor = MaterialTheme.colors.primary,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[state.currentTabIndex])
                )
            }
        ) {
            tabs.forEachIndexed { index, tab ->
                LeadingIconTab(
                    icon = {
                        Icon(
                            painter = painterResource(tab.icon),
                            contentDescription = tab.title
                        )
                    },
                    text = { Text(text = tab.title) },
                    selected = state.currentTabIndex == index,
                    onClick = { viewModel.changeTabIndex(index) }
                )
            }
        }
        when (state.currentTabIndex) {
            0 -> AircraftListScreen()
            1 -> AircraftMapScreen { viewModel.changeTabIndex(0) }
        }
    }
}

