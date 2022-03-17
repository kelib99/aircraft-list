package link.krupa.martin.aircraftlist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import link.krupa.martin.aircraftlist.common.Constants
import link.krupa.martin.aircraftlist.data.remote.OpenSkyApi
import link.krupa.martin.aircraftlist.data.repository.AircraftRepositoryImpl
import link.krupa.martin.aircraftlist.domain.repository.AircraftRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOpenSkyApi() : OpenSkyApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenSkyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAircraftRepository(api : OpenSkyApi) : AircraftRepository {
        return AircraftRepositoryImpl(api)
    }


}