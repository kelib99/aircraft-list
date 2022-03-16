package link.krupa.martin.aircraftlist.presentation

sealed class Screen (val route : String) {
    object  AircraftListScreen : Screen("aircraft_list_screen")
    object AircraftMapScreen : Screen("aircraft_map_screen")
}