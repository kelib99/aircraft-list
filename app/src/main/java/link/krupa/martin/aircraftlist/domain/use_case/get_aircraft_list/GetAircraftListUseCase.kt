package link.krupa.martin.aircraftlist.domain.use_case.get_aircraft_list

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import link.krupa.martin.aircraftlist.R
import link.krupa.martin.aircraftlist.common.Device
import link.krupa.martin.aircraftlist.common.Resource
import link.krupa.martin.aircraftlist.domain.model.Aircraft
import link.krupa.martin.aircraftlist.domain.repository.AircraftRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAircraftListUseCase @Inject constructor(
    private val repository: AircraftRepository,
    private val context : Context
) {
    operator fun invoke() : Flow<Resource<List<Aircraft>>> = flow {
        try {
            if(!Device.isOnline(context)) {
                emit(Resource.Offline())
                return@flow
            }
            emit(Resource.Loading())
            val aircraftList = repository.getAircraftList()
            emit(Resource.Success(aircraftList.map { it.toAircraft() }))

        } catch (e: HttpException) {
            //Server responded with error code
            emit(Resource.Error(e.localizedMessage ?: context.getString(R.string.error_unexpected)))

        } catch (e : IOException) {
            //Server is offline
            emit(Resource.Error(context.getString(R.string.server_unreachable)))
        }
    }
}