package link.krupa.martin.aircraftlist.data.remote.dto

import link.krupa.martin.aircraftlist.domain.model.Aircraft
import java.lang.Exception

/**
 * This class represents Data transfer object of State property as it is - simple list of values
 * Documentation can be found here: https://openskynetwork.github.io/opensky-api/rest.html#all-state-vectors
 */
class StateDto : ArrayList<Any>()

/**
 * Converts API object State to Aircraft, which is better usable, because all values are named
 */
fun StateDto.toAircraftDto(): AircraftDto? {
    return try {
        AircraftDto(
            icao24 = this[0] as String,
            callsign = this[1] as String?,
            originCountry = this[2] as String,
            timePosition = this[3] as Double?,
            lastContact = this[4] as Double,
            longitude = this[5] as Double?,
            latitude = this[6] as Double?,
            baroAltitude = this[7] as Double?,
            onGround = this[8] as Boolean,
            velocity = this[9] as Double?,
            trueTrack = this[10] as Double?,
            verticalRate = this[11] as Double?,
            sensors = this[12] as IntArray?,
            geoAltitude = this[13] as Double?,
            squawk = this[14] as String?,
            spi = this[15] as Boolean,
            positionSource = this[16] as Double
        )
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
/**
 * This class represents same property as StateDto, but all values are named
 */
data class AircraftDto(
    val icao24: String,
    val callsign: String?,
    val originCountry: String,
    val timePosition: Double?,
    val lastContact: Double,
    val longitude: Double?,
    val latitude: Double?,
    val baroAltitude: Double?,
    val onGround: Boolean,
    val velocity: Double?,
    val trueTrack: Double?,
    val verticalRate: Double?,
    val sensors: IntArray?,
    val geoAltitude: Double?,
    val squawk: String?,
    val spi: Boolean,
    val positionSource: Double
) {

    fun toAircraft() : Aircraft {
        return Aircraft(
            icao24 = icao24,
            callsign = callsign,
            originCountry = originCountry,
            longitude = longitude,
            latitude = latitude,
            baroAltitude = baroAltitude,
            verticalRate = verticalRate,
            onGround = onGround,
            velocity = velocity,
            trueTrack = trueTrack
        )
    }
    //equals and hasCode must be generated because of sensors value of type IntArray
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AircraftDto

        if (icao24 != other.icao24) return false
        if (callsign != other.callsign) return false
        if (originCountry != other.originCountry) return false
        if (timePosition != other.timePosition) return false
        if (lastContact != other.lastContact) return false
        if (longitude != other.longitude) return false
        if (latitude != other.latitude) return false
        if (baroAltitude != other.baroAltitude) return false
        if (onGround != other.onGround) return false
        if (velocity != other.velocity) return false
        if (trueTrack != other.trueTrack) return false
        if (verticalRate != other.verticalRate) return false
        if (!sensors.contentEquals(other.sensors)) return false
        if (geoAltitude != other.geoAltitude) return false
        if (squawk != other.squawk) return false
        if (spi != other.spi) return false
        if (positionSource != other.positionSource) return false

        return true
    }

    override fun hashCode(): Int {
        var result = icao24.hashCode()
        result = 31 * result + (callsign?.hashCode() ?: 0)
        result = 31 * result + originCountry.hashCode()
        result = 31 * result + (timePosition?.hashCode() ?: 0)
        result = 31 * result + lastContact.hashCode()
        result = 31 * result + (longitude?.hashCode() ?: 0)
        result = 31 * result + (latitude?.hashCode() ?: 0)
        result = 31 * result + (baroAltitude?.hashCode() ?: 0)
        result = 31 * result + onGround.hashCode()
        result = 31 * result + (velocity?.hashCode() ?: 0)
        result = 31 * result + (trueTrack?.hashCode() ?: 0)
        result = 31 * result + (verticalRate?.hashCode() ?: 0)
        result = 31 * result + sensors.contentHashCode()
        result = 31 * result + (geoAltitude?.hashCode() ?: 0)
        result = 31 * result + (squawk?.hashCode() ?: 0)
        result = 31 * result + spi.hashCode()
        result = 31 * result + positionSource.hashCode()
        return result
    }
}