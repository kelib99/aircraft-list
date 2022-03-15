package link.krupa.martin.aircraftlist.data.remote

import link.krupa.martin.aircraftlist.common.Constants
import link.krupa.martin.aircraftlist.data.remote.dto.StateDto
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenSkyApi {

    @GET("states/all")
    suspend fun getAllAircrafts(
        @Query("lamin") lamin: String = Constants.CZECHIA_LAMIN,
        @Query("lomin") lomin: String = Constants.CZECHIA_LOMIN,
        @Query("lamax") lamax: String = Constants.CZECHIA_LAMAX,
        @Query("lomax") lomax: String = Constants.CZECHIA_LOMAX
    ) : List<StateDto>
}