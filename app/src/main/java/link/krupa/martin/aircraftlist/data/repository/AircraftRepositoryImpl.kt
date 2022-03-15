package link.krupa.martin.aircraftlist.data.repository

import link.krupa.martin.aircraftlist.data.remote.OpenSkyApi
import link.krupa.martin.aircraftlist.data.remote.dto.AircraftDto
import link.krupa.martin.aircraftlist.data.remote.dto.toAircraftDto
import link.krupa.martin.aircraftlist.domain.repository.AircraftRepository
import javax.inject.Inject

class AircraftRepositoryImpl @Inject constructor(
    private val api : OpenSkyApi
) : AircraftRepository {
    override suspend fun getAllAircraft(): List<AircraftDto> {
        val stateDtoList = api.getAllAircrafts()
        val nullableAircraftDtoList = stateDtoList.map { it.toAircraftDto() }
        return nullableAircraftDtoList.filterNotNull()
    }
}