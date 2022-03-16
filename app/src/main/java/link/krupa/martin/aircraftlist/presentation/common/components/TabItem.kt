package link.krupa.martin.aircraftlist.presentation.common.components

import android.content.Context
import link.krupa.martin.aircraftlist.R

sealed class TabItem(var icon : Int, var title : String) {
    class AircraftList(context: Context) :
        TabItem(android.R.drawable.ic_menu_sort_by_size, context.getString(R.string.bottom_nav_list_name))
    class AircraftMap(context: Context) :
        TabItem(android.R.drawable.ic_menu_mapmode, context.getString(R.string.bottom_nav_map_name))
}
