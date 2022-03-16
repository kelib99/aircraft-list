package link.krupa.martin.aircraftlist.domain.model


data class Aircraft(
    val icao24: String,
    val callsign: String?,
    val originCountry: String,
    val longitude: Double?,
    val latitude: Double?,
    val baroAltitude: Double?,
    val onGround: Boolean,
    val velocity: Double?,
    val trueTrack: Double?,
)