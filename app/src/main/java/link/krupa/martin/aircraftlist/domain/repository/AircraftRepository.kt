package link.krupa.martin.aircraftlist.domain.repository

import link.krupa.martin.aircraftlist.data.remote.dto.AircraftDto

interface AircraftRepository {
    suspend fun getAllAircraft() : List<AircraftDto>
}