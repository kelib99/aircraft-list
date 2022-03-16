package link.krupa.martin.aircraftlist.data.repository

import link.krupa.martin.aircraftlist.data.remote.OpenSkyApi
import link.krupa.martin.aircraftlist.data.remote.dto.AircraftDto
import link.krupa.martin.aircraftlist.data.remote.dto.toAircraftDto
import link.krupa.martin.aircraftlist.domain.repository.AircraftRepository
import javax.inject.Inject

class AircraftRepositoryImpl @Inject constructor(
    private val api : OpenSkyApi
) : AircraftRepository {
    override suspend fun getAircraftList(): List<AircraftDto> {
        val stateAllDto  = api.getAircraftList()
        val nullableAircraftDtoList = stateAllDto.states.map { it.toAircraftDto() }
        return nullableAircraftDtoList.filterNotNull()
    }
}