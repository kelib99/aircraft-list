package link.krupa.martin.aircraftlist

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import link.krupa.martin.aircraftlist.common.Constants
import link.krupa.martin.aircraftlist.data.remote.OpenSkyApi
import link.krupa.martin.aircraftlist.data.repository.AircraftRepositoryImpl
import link.krupa.martin.aircraftlist.domain.repository.AircraftRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@HiltAndroidApp
class AircraftApplication : Application()